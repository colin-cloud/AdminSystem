package com.example.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 小白学java
 * @version 3.0
 */
@ConfigurationProperties("example.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
