package com.github.example.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Arvin.
 */
public class ConditionalOnPropertyConfigurationTest {

    @Test
    public void bean11() {

        System.setProperty("enabled.bean11", "");
        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(ConditionalOnPropertyConfiguration.class);
        assertTrue(acx.containsBean("bean11"));
        acx.destroy();

        System.setProperty("enabled.bean11", "false");
        acx = new AnnotationConfigApplicationContext(ConditionalOnPropertyConfiguration.class);
        assertFalse(acx.containsBean("bean11"));
        acx.destroy();

        System.setProperty("enabled.bean11", "true");
        acx = new AnnotationConfigApplicationContext(ConditionalOnPropertyConfiguration.class);
        assertTrue(acx.containsBean("bean11"));
        acx.destroy();


    }
}