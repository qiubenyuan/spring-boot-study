package com.github.example.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Arvin.
 */
public class ConditionalOnExpressionConfigurationTest {

    @Test
    public void bean11() {
        System.setProperty("bean11", "true");
        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(ConditionalOnExpressionConfiguration.class);
        assertTrue(acx.containsBean("bean11"));
        acx.destroy();

        System.setProperty("bean11", "false");
        acx = new AnnotationConfigApplicationContext(ConditionalOnExpressionConfiguration.class);
        assertFalse(acx.containsBean("bean11"));
        acx.destroy();

        System.setProperty("all", "true");
        acx = new AnnotationConfigApplicationContext(ConditionalOnExpressionConfiguration.class);
        assertTrue(acx.containsBean("bean12"));
        acx.destroy();

        System.setProperty("all", "false");
        System.setProperty("bean12", "true");
        acx = new AnnotationConfigApplicationContext(ConditionalOnExpressionConfiguration.class);
        assertTrue(acx.containsBean("bean12"));
        acx.destroy();

        System.setProperty("all", "false");
        System.setProperty("bean12", "false");
        acx = new AnnotationConfigApplicationContext(ConditionalOnExpressionConfiguration.class);
        assertFalse(acx.containsBean("bean12"));
        acx.destroy();

    }
}