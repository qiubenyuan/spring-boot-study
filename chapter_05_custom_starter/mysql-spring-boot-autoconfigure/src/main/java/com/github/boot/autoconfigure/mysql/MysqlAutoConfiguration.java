package com.github.boot.autoconfigure.mysql;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 17:58
 */
@Configuration
@ConditionalOnClass(DataSource.class)
@EnableConfigurationProperties(MysqlProperties.class)
public class MysqlAutoConfiguration {



}
