# 认证授权服务  SecurityOAuth2 JWT 


## sql 
    DROP TABLE IF EXISTS `oauth_client_details`;
        CREATE TABLE `oauth_client_details`  (
                  `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户端标
        识',
                  `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
        COMMENT '接入资源列表',
                  `client_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
        COMMENT '客户端秘钥',
                  `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                  `authorized_grant_types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT
                NULL,
      `web_server_redirect_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT
                NULL,
      `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                  `access_token_validity` int(11) NULL DEFAULT NULL,
                  `refresh_token_validity` int(11) NULL DEFAULT NULL,
                  `additional_information` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE
        CURRENT_TIMESTAMP(0),
      `archived` tinyint(4) NULL DEFAULT NULL,
                  `trusted` tinyint(4) NULL DEFAULT NULL,
                  `autoapprove` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                  PRIMARY KEY (`client_id`) USING BTREE
    ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接入客户端信息'
        ROW_FORMAT = Dynamic;
        INSERT INTO `oauth_client_details` VALUES ('c1', 'res1',
                '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', 'ROLE_ADMIN,ROLE_USER,ROLE_API',
                'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com',
        NULL, 7200, 259200, NULL, '2019‐09‐09 16:04:28', 0, 0, 'false');
        INSERT INTO `oauth_client_details` VALUES ('c2', 'res2',
                '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', 'ROLE_API',
                'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com',
        NULL, 31536000, 2592000, NULL, '2019‐09‐09 21:48:51', 0, 0, 'false');
        
        
        
        
        
        
        DROP  TABLE  IF  EXISTS  `oauth_code`;
            CREATE  TABLE  `oauth_code`    (
                        `create_time`  timestamp(0)  NOT  NULL  DEFAULT  CURRENT_TIMESTAMP,
                        `code`  varchar(255)  CHARACTER  SET  utf8  COLLATE  utf8_general_ci  NULL  DEFAULT  NULL,
                        `authentication`  blob  NULL,
                        INDEX  `code_index`(`code`)  USING  BTREE
        )  ENGINE  =  InnoDB  CHARACTER  SET  =  utf8  COLLATE  =  utf8_general_ci  ROW_FORMAT  =  Compact;