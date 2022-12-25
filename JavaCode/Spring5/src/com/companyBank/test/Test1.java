package com.companyBank.test;

import com.companyBank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 小白学java
 * @version 3.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:account.xml")
public class Test1 {
    @Autowired
    private AccountService accountService;
    @Test
    public void test() {
        accountService.account();
    }

}
