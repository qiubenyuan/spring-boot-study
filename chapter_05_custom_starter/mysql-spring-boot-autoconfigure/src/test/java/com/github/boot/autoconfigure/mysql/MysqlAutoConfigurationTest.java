package com.github.boot.autoconfigure.mysql;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 18:39
 */
public class MysqlAutoConfigurationTest {

    @Test
    public void properties() {

        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(MysqlAutoConfiguration.class);

        MysqlProperties properties = acx.getBean(MysqlProperties.class);

        System.out.println(properties.getUsername());
        System.out.println(properties.getPassword());
    }

}