# What spring boot it's?
    本项目阐述 Spring Boot 到底是什么？
    
    官网地址： https://spring.io/projects/spring-boot#overview
    文档地址： https://docs.spring.io/spring-boot/docs/1.5.14.RELEASE/reference/htmlsingle/
    

# spring boot 介绍
    官网介绍地址： https://docs.spring.io/spring-boot/docs/1.5.14.RELEASE/reference/htmlsingle/#getting-started-introducing-spring-boot
    
    英文介绍：
         Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”. 
         We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. 
         Most Spring Boot applications need very little Spring configuration.
         
         You can use Spring Boot to create Java applications that can be started using java -jar or more traditional war deployments.
         We also provide a command line tool that runs “spring scripts”.
         
         Our primary goals are:
         
         1. Provide a radically faster and widely accessible getting started experience for all Spring development.
         2. Be opinionated out of the box, but get out of the way quickly as requirements start to diverge from the defaults.
         3. Provide a range of non-functional features that are common to large classes of projects 
            (e.g. embedded servers, security, metrics, health checks, externalized configuration).
         4. Absolutely no code generation and no requirement for XML configuration.
         
    个人的理解：
        spring boot 只是提供了一种新的代码组织方式，本质还是基于 spring，只是给许多常用的组件提供了许多默认的行为，让开发者更加容易的使用，可以完全无XML
        
        spring boot 不去考虑具体某个领域的具体实现（如数据库连接池，ZK，Redis等等），他专注的是如何更加容易使用现有的这些框架，降低使用的成本
    
    
# spring boot 能做什么
    从介绍中我们知道，其实 spring boot 本身没有实现具体的功能，只是提供了一种更加易于使用 spring 以及集成其他框架组件的方式，那么他到底提供了哪些易于使用的特性呢？
    
## 自动配置
    自动配置是 spring boot 的最核心特性，官网的介绍如下：
        https://docs.spring.io/spring-boot/docs/1.5.14.RELEASE/reference/htmlsingle/#using-boot-auto-configuration
        
    官网的描述阐述了几个点：
        1. spring boot 能够坚持 classpath 路径下引入的类，然后如果发现你程序中没有配置相应的Bean则会默认在Spring容器中配置一个Bean
           (所以你如果不需要某个功能特性就不要引入相关的jar，否则默认行为下你可能不知道 spring boot 给你创建了什么)
           
        2. spring boot 的自动配置是无侵入性的，开发者可以通过自定义自己的Bean替换掉 spring boot 自己生成的Bean
           (如果你想知道哪些默认配置是生效的，可以在执行程序的时候添加 --debug)
        
        3. 禁用特性的自动配置类，有时候你引入了相关jar，但只是想用其中的一部分自动配置，你可以禁用一些自动配置项
            @Configuration
            @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
            public class MyConfiguration {
                // ......
            }
        
## 提供各种组件的起步依赖
    在实际开发中，引入什么依赖其实是个很具有挑战性的问题，需要什么库？maven坐标是什么？引入的库又需要配合什么别的库？引入的库有哪些冲突？
    在以往的方法返回是中，我们经常要思考这类问题，期望引入最小化且无冲突的依赖，其实这是很耗时间精力的事情。

    幸运的是， spring boot 给我们提供了许多 starter，也就是 起步依赖包，比如web，我们只需要引入：
        org.springframework.boot:spring-boot-starter-web
    然后你的应用就已经具备了 web 所要用的依赖，什么日志啦，内嵌容器啦都有了


## 内嵌容器
    通常我们开发一个Web应用，我还要去网上下载 对应的容器，然后还要求IDE支持，要启动得先打个war包，然后各种配置最终才能把这个web给跑起来
    spring boot 提供了很多的内嵌容器，比如 tomcat，jetty，React Native，引入起步依赖后只需要直接运行 main 函数就能把web项目启动
    生产环境下更是只需要 java -jar xxx.jar 运行相关的jar就能启动一个web容器。


## Actuator
    Actuator则要提供在运行时检视应用程序内部情况的能力。安装了Actuator就能窥探应用程序的内部情况了，包括如下细节：
    
    1. Spring应用程序上下文里配置的Bean
    2. Spring Boot的自动配置做的决策
    3. 应用程序取到的环境变量、系统属性、配置属性和命令行参数
    4. 应用程序里线程的当前状态
    5. 应用程序最近处理过的HTTP请求的追踪情况
    6. 各种和内存用量、垃圾回收、Web请求以及数据源用量相关的指标
    
    Actuator通过Web端点和shell界面向外界提供信息。如果要借助shell界面，你可以打开SSH（Secure Shell），登入运行中的应用程序，发送指令查看它的情况。
    
## YML 格式配置文件支持
    传统项目中使用properties文件作为key-value的载体，但其缺点也是明显的。会重复的进行链式配置，而YML文件则避免了这个问题。
    
    















