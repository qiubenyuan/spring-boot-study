package com.github.example.configuration;

import com.github.example.bean.Bean1;
import com.github.example.bean.Bean2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 19:59
 */
@Configuration
public class ConditionalOnBeanConfiguration {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

    /**
     * 当 Bean1 存在的时候才会创建 Bean2
     *
     * @return
     */
    @Bean
    @ConditionalOnBean(Bean1.class)
    public Bean2 bean2() {
        return new Bean2();
    }

}
