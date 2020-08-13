# 联系    BraveLionet@163.com


## application.yml -> application-dev.yml
## 例如 idea 启动需将 Program arguments --spring.profiles.active=dev 即可

## 注 : Eureka存在闭源情况(bl-springcloud-eureka-server),不再进行做详细案例,持续做 SpringCloudAlibaba代替
## 如有童鞋希望学习 Eureka 





## OAuth2学习路径
#### bl-springcloud-oauth2-authorization-server 授权认证服务  
##### bl-springcloud-oauth2-authorization-client 资源管理服务     
    bl-springcloud-oauth2-authorization-server
        --^  bl-springboot-security-authorization
        --^  bl-springboot-security
        --^  bl-springmvc-session-oauth
        --^  bl-springmvc-security

## 分布式 SpringSecurityOAuth2 授权

        bl-springcloud-oauth2-gateway-server 网关拦截认证及授权, 分发 request
        bl-springcloud-oauth2-authorization-system 认证服务
        bl-springcloud-oauth2-resource-server 资源服务
        
        依赖 : 
            bl-springcloud-eureka-server Eureka注册中心
            
        服务治理: 
            bl-springbootadmin  开启所有健康检查,生产禁止使用所有检查
            
         