package com.github.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import javax.servlet.ServletException;
import java.io.File;

/**
 * 使用内嵌的 Tomcat 启动项目
 * Created by Arvin.
 */
public class EmbedTomcatMain {

    public static void main(String[] args) throws ServletException, LifecycleException {

        String basePath = "chapter_02_web_dev_experience/direct_spring_web/";

        //String webappDirLocation = basePath + "/src/main/webapp";
        String webappDirLocation = basePath + "/src/main/resources";

        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        ctx.addParameter("contextConfigLocation", "classpath:applicationContext.xml");
        ctx.addApplicationListener("org.springframework.web.context.ContextLoaderListener");

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File(basePath + "target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);

        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));

        ctx.setResources(resources);

        FilterDef filterDef = new FilterDef();
        filterDef.setFilterClass("org.springframework.web.filter.CharacterEncodingFilter");
        filterDef.setFilterName("encoding");
        filterDef.addInitParameter("encoding", "UTF-8");

        ctx.addFilterDef(filterDef);
        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName("encoding");
        filterMap.addURLPattern("/*");

        ctx.addFilterMap(filterMap);

        tomcat.addServlet("", "dispatcher", "org.springframework.web.servlet.DispatcherServlet")
                .addInitParameter("contextConfigLocation", "classpath:applicationContext-web.xml");

        tomcat.start();

        tomcat.getServer().await();

    }
}
