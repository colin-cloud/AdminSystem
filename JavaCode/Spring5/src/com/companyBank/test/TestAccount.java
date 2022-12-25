package com.companyBank.test;

import com.companyBank.config.Config;
import com.companyBank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestAccount {
    @Test
    public void testAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("account.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.account();
    }

    @Test
    public void testAccount2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.account();
    }
}
