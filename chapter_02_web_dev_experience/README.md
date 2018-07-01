# Web 开发体验
    在 chapter_01 中我们对 spring boot 进行了一个简单的介绍，当时纯文字的东西，表现力总是不够，chapter_02 希望通过一个直接使用 Spring 以及使用
    spring boot 来构建一个web应用，对比这两种方式来体会 spring boot 的一些特性。


# 直接使用 Spring 构建Web项目
    直接使用 Spring 构建 Web 项目，我们可能要配置web.xml, 添加 Spring 的监听器，配置Spring的DispatcherServlet
    还要配置视图解析器，自己引入日志，配置Tomcat服务器等等，很多的繁琐工作。
    
    对于一个新手，要折腾这些东西，读文档估计也要好久
    
    1. 配置 web.xml, 增加Spring监听器，请求分发 Servlet
    2. 找到 Spring 相关依赖，servlet api 依赖，JSTL 依赖
    3. 小心谨慎引入日志依赖，什么common-logging, slf4j,log4j... 够你搞半天
    4. 编写 Spring XML 配置文件，期间还要考虑使用什么Schema 头（这个估计查文档都要查好久，熟悉源码的话，直接可以去源码找）
    5. 编写视图解析器，通常是 JSP
    6. 编写业务Bean
    7. 下载 Tomcat
    8. 配置 Tomcat 容器，还得依赖IDE功能
    9. 启动 Tomcat 服务器
    
    整个过程，对于新手而言，可能搞半天都没搞出来，耗时
    
# 使用 SpringBoot 构建Web项目
    使用 spring boot 构建 web 项目就显得优雅很多，几个步骤就能启动一个完整的Web项目。
    1. 引入一个 Spring Boot 的BOM 或者使用 spring boot 的parent
    2. 引入 web 起步依赖 spring-boot-starter-web
    3. 编写 启动Main函数，Controller 等业务Bean
    4. 启动Main函数即完成一个简单的Web项目
 
    整个过程预计也就几分钟的事情，我们不需要考虑要引入什么包，是否有冲突等等，较少的代价就能完成









