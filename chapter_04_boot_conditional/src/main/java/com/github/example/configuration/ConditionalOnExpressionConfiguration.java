package com.github.example.configuration;

import com.github.example.bean.Bean1;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Arvin.
 */
@Configuration
public class ConditionalOnExpressionConfiguration {

    @Bean
    //@ConditionalOnExpression("'${bean11}' eq 'true'")
    //@ConditionalOnExpression("${bean11} eq true")
    @ConditionalOnExpression("${bean11:true}")
    public Bean1 bean11() {
        return new Bean1("bean11");
    }

    @Bean
    @ConditionalOnExpression("${all:true} or ${bean12:true}")
    public Bean1 bean12() {
        return new Bean1("bean12");
    }
}
