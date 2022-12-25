package com.example.admin.mapper;

import com.example.admin.bean.Bank;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小白学java
 * @version 3.0
 */
@Mapper
public interface BankMapper {

    public Bank getBank(Integer id);
}
