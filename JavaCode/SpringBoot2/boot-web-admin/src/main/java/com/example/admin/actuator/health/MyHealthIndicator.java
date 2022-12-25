package com.example.admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    /**
     * 真实的检验方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> map = new HashMap();
        if (true) {
            builder.up();
        } else {
            builder.down();
        }
        builder.withDetails(map);//携带详细信息
    }
}
