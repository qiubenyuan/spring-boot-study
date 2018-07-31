package com.github.example.configuration;

import com.github.example.bean.Bean1;
import com.github.example.bean.Bean2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 16:15
 */
@Configuration
public class ConditionalOnSingleCandidateConfiguration {

    @Bean
    public Bean1 conditionalOnSingleCandidateBean1() {
        return new Bean1();
    }

    /**
     * 如果 容器中包含了一个 Bean1 或者多个的时候，存在一个 Bean1 有 Primary的该条件生效
     *
     * @return
     */
    @Bean
    @ConditionalOnSingleCandidate(Bean1.class)
    public Bean2 conditionalOnSingleCandidateBean2() {
        return new Bean2();
    }

}
