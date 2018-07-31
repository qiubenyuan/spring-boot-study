package com.github.example.configuration;

import com.github.example.bean.Bean2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 16:20
 */
public class ConditionalOnSingleCandidateConfigurationTest {

    public void showBeanNames(String[] beanNames) {

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }

    @Test
    public void conditionalOnSingleCandidateBean() throws Exception {

        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(ConditionalOnSingleCandidateConfiguration.class);

        showBeanNames(acx.getBeanDefinitionNames());

        Bean2 bean = acx.getBean(Bean2.class);


        assertNotNull(bean);


    }

    @Test
    public void conditionalOnSingleCandidateMultiBean() throws Exception {

        AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(ConditionalOnSingleCandidateConfigurationMulti.class);

        Bean2 bean = acx.getBean(Bean2.class);

        assertNotNull(bean);
    }

}