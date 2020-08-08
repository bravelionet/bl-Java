# security 授权

#表
     用户表
         CREATE TABLE `user` (
           `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
           `user_name` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称,唯一',
           `password` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
           `fullname` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
           `mobile` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
           PRIMARY KEY (`id`,`user_name`)
         ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
    
    角色表
          CREATE TABLE `role` (
            `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
            `role_name` varchar(15) NOT NULL COMMENT '角色名',
            `description` varchar(20) NOT NULL COMMENT '角色描述',
            `create_time` datetime DEFAULT NULL,
            `update_time` datetime DEFAULT NULL,
            `status` int(2) DEFAULT NULL COMMENT '1 : 启用, 0 废弃',
            PRIMARY KEY (`id`,`role_name`) USING BTREE
          ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
          
    
      用户角色对应表
          CREATE TABLE `user_role` (
            `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
            `user_id` bigint(10) NOT NULL COMMENT '用户 id',
            `role_id` bigint(10) NOT NULL COMMENT '校色id',
            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
            `creator` varchar(20) NOT NULL COMMENT '创建者',
            `status` int(2) DEFAULT NULL COMMENT '1: 启动. 0废弃',
            PRIMARY KEY (`id`)
          ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色对应关系';
          
          
       
       角色权限对应关系表
            CREATE TABLE `role_permission` (
              `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
              `role_id` bigint(10) NOT NULL COMMENT '角色 Id',
              `permission_id` bigint(10) NOT NULL COMMENT '权限 Id',
              PRIMARY KEY (`id`),
              UNIQUE KEY `role_permission` (`role_id`,`permission_id`) USING BTREE COMMENT '角色_权限对应关系'
            ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
            
            
        
        权限表
            CREATE TABLE `permission` (
              `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
              `code` varchar(20) NOT NULL COMMENT '权限标识符',
              `description` varchar(20) DEFAULT NULL COMMENT '描述',
              `url` varchar(30) DEFAULT NULL COMMENT '请求地址',
              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
              `status` int(2) DEFAULT NULL COMMENT '1 : 启用, 0 废弃',
              PRIMARY KEY (`id`)
            ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';
            