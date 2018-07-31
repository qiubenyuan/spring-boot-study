package com.github.example.configuration;

import com.github.example.bean.Bean1;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Arvin.
 */
@Configuration
public class ConditionalOnPropertyConfiguration {


    /**
     * 只要 enabled.bean1 != false 且不为null 的时候初始化该 Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "enabled", name = "bean11")
    public Bean1 bean11() {
        return new Bean1("bean11");
    }

}
