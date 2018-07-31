package com.github.example.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 20:01
 */
public class ConditionalOnBeanConfigurationTest {

    @Test
    public void conditionalOnBean() {

        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(ConditionalOnBeanConfiguration.class);

        assertTrue(acx.containsBean("bean1"));
        assertTrue(acx.containsBean("bean2"));

    }
}