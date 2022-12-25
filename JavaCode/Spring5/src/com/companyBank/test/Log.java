package com.companyBank.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Log {

    private static final Logger log = LoggerFactory.getLogger(Log.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
    }
}
