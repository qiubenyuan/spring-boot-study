package com.github.boot.autoconfigure.mysql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO
 *
 * @author Arvin
 * @version 1.0
 * @since 2018/7/31 17:50
 */
@ConfigurationProperties(prefix = "example.mysql", ignoreUnknownFields = true)
public class MysqlProperties {

    @Value("${aaa}")
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
