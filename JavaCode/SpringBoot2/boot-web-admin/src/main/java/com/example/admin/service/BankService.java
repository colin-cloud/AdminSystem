package com.example.admin.service;

import com.example.admin.bean.Bank;
import com.example.admin.mapper.BankMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
//@MapperScan("com.example.admin.*")
public class BankService {

    @Autowired
    BankMapper bankMapper;

    public Bank getBankById(Integer id) {
        Bank bank = bankMapper.getBank(id);
        return bank;
    }
}
