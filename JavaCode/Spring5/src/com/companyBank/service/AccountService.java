package com.companyBank.service;

import com.companyBank.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
@Transactional (readOnly = false, timeout = -1, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ) //设置隔离级别和传播行为
// 这个类里面所有的方法都添加了事务, 也可以在单一方法上添加该注解
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void addMoney() {
        accountDao.addMoney();
    }

    public void exportMoney() {
        accountDao.exportMoney();
    }

    public void account() {
        addMoney();
        int i  = 10 / 0;
//        try {
////            int i = 10 / 0;
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
        exportMoney();
    }
}
