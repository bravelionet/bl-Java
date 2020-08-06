# Springboot 集成 security
    1. springboot 集成更加方便快捷
    2. 步骤 : 
            yml 配置 mvc 视图解析器(静态资源访问地址...) 
            配置 Security 配置文件, 配置拦截/放行路径,配置密码编码格式
            ViewControllerRegistry 中配置登录页面
            
# 工作原理
    1. SpringSecurity 对 web 资源保护是 Fiflter 实现的(过滤链)
    2. 初始化时默认会创建一个 名为 springSecurityFilterChain的过滤器
    3. 真正起作用的是FilterChainProxy中SecurityFilterChain所包含的各个Filter
    4. 用户认证及授权是交给 认证管理器（AuthenticationManager）和决策管理器（AccessDecisionManager）进行处理
    5. SecurityContextPersistenceFilter 这个Filter是整个拦截过程的入口和出口（也就是第一个和最后一个拦截
       器），会在请求开始时从配置好的 SecurityContextRepository 中获取 SecurityContext，然后把它设置给
       SecurityContextHolder。在请求完成后将 SecurityContextHolder 持有的 SecurityContext 再保存到配置好
       的 SecurityContextRepository，同时清除 securityContextHolder 所持有的 SecurityContext；
    6. UsernamePasswordAuthenticationFilter 用于处理来自表单提交的认证。该表单必须提供对应的用户名和密
       码，其内部还有登录成功或失败后进行处理的 AuthenticationSuccessHandler 和
       AuthenticationFailureHandler
    7. FilterSecurityInterceptor 是用于保护web资源的，使用AccessDecisionManager对当前用户进行授权访问(资源访问权限)
    8. ExceptionTranslationFilter 能够捕获来自 FilterChain 所有的异常，并进行处理。但是它只会处理两类异常：
       AuthenticationException 和 AccessDeniedException，其它的异常它会继续抛出
####  认证流程
        1.  用户提交用户名、密码被SecurityFilterChain中的 UsernamePasswordAuthenticationFilter 过滤器获取到，
        封装为请求Authentication，通常情况下是UsernamePasswordAuthenticationToken这个实现类。
        
        2. 然后过滤器将Authentication提交至认证管理器（AuthenticationManager）进行认证
        
        3. 认证成功后， AuthenticationManager 身份管理器返回一个被填充满了信息的（包括上面提到的权限信息，
        身份信息，细节信息，但密码通常会被移除） Authentication 实例。
        
        4.  SecurityContextHolder 安全上下文容器将第3步填充了信息的 Authentication ，通过
            SecurityContextHolder.getContext().setAuthentication(…)方法，设置到其中。
            可以看出AuthenticationManager接口（认证管理器）是认证相关的核心接口，也是发起认证的出发点，它
            的实现类为ProviderManager。而Spring Security支持多种认证方式，因此ProviderManager维护着一个
            List<AuthenticationProvider> 列表，存放多种认证方式，最终实际的认证工作是由
            AuthenticationProvider完成的。咱们知道web表单的对应的AuthenticationProvider实现类为
            DaoAuthenticationProvider，它的内部又维护着一个UserDetailsService负责UserDetails的获取。最终
            AuthenticationProvider将UserDetails填充至Authentication。
####   授权流程

        1. AccessDecisionManager（访问决策管理器）的核心接口
        2. 参数：
                authentication：要访问资源的访问者的身份
                object：要访问的受保护资源，web请求对应FilterInvocation
                configAttributes：是受保护资源的访问策略，通过SecurityMetadataSource获取。
                decide接口就是用来鉴定当前用户是否有访问对应受保护资源的权限。
        3. AccessDecisionManager采用投票的方式来确定是否能够访问受保护资源
                AccessDecisionManager中包含的一系列AccessDecisionVoter将会被用来对Authentication, 是否有权访问受保护对象进行投票，AccessDecisionManager根据投票结果，做出最终决策。
        4. AccessDecisionVoter是一个接口，其中定义有三个方法
                public interface AccessDecisionVoter<S> {
                    int ACCESS_GRANTED = 1;
                    int ACCESS_ABSTAIN = 0;
                    int ACCESS_DENIED = ‐1;
                    boolean supports(ConfigAttribute var1);
                    boolean supports(Class<?> var1);
                    int vote(Authentication var1, S var2, Collection<ConfigAttribute> var3);
                }  
                  
               vote()方法的返回结果会是AccessDecisionVoter中定义的三个常量之一。ACCESS_GRANTED表示同意，
               ACCESS_DENIED表示拒绝，ACCESS_ABSTAIN表示弃权。如果一个AccessDecisionVoter不能判定当前
               Authentication是否拥有访问对应受保护对象的权限，则其vote()方法的返回值应当为弃权ACCESS_ABSTAIN。
                     Spring Security内置了三个基于投票的AccessDecisionManager实现类如下，它们分别是
               AffirmativeBased、ConsensusBased和UnanimousBased，。
                     AffirmativeBased的逻辑是：
                     （1）只要有AccessDecisionVoter的投票为ACCESS_GRANTED则同意用户进行访问；
                     （2）如果全部弃权也表示通过；
                     （3）如果没有一个人投赞成票，但是有人投反对票，则将抛出AccessDeniedException。
               Spring security默认使用的是AffirmativeBased。
                     ConsensusBased的逻辑是：
                     （1）如果赞成票多于反对票则表示通过。
                     （2）反过来，如果反对票多于赞成票则将抛出AccessDeniedException。
                     （3）如果赞成票与反对票相同且不等于0，并且属性allowIfEqualGrantedDeniedDecisions的值为true，则表
               示通过，否则将抛出异常AccessDeniedException。参数allowIfEqualGrantedDeniedDecisions的值默认为true。
                    （4）如果所有的AccessDecisionVoter都弃权了，则将视参数allowIfAllAbstainDecisions的值而定，如果该值
              为true则表示通过，否则将抛出异常AccessDeniedException。参数allowIfAllAbstainDecisions的值默认为false。
                    UnanimousBased的逻辑与另外两种实现有点不一样，另外两种会一次性把受保护对象的配置属性全部传递
              给AccessDecisionVoter进行投票，而UnanimousBased会一次只传递一个ConfigAttribute给
              AccessDecisionVoter进行投票。这也就意味着如果我们的AccessDecisionVoter的逻辑是只要传递进来的
              ConfigAttribute中有一个能够匹配则投赞成票，但是放到UnanimousBased中其投票结果就不一定是赞成了。
              UnanimousBased的逻辑具体来说是这样的：
                    （1）如果受保护对象配置的某一个ConfigAttribute被任意的AccessDecisionVoter反对了，则将抛出
              AccessDeniedException。
                    （2）如果没有反对票，但是有赞成票，则表示通过。
                    （3）如果全部弃权了，则将视参数allowIfAllAbstainDecisions的值而定，true则通过，false则抛出
              AccessDeniedException。
              Spring Security也内置一些投票者实现类如RoleVoter、AuthenticatedVoter和WebExpressionVoter等 