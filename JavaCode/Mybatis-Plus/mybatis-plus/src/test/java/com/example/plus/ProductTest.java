package com.example.plus;

import com.example.plus.bean.Product;
import com.example.plus.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 小白学java
 * @version 3.0
 */
@SpringBootTest
@Slf4j
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01() {
        //小李查询商品价格
        Product product1 = productMapper.selectById(1);
        log.info("小李查询的商品价格为{}", product1.getPrice());
        Product product2 = productMapper.selectById(1);
        log.info("小王查询的商品价格为{}", product2.getPrice());
        //小李更新价格
        product1.setPrice(product1.getPrice() + 50);
        productMapper.updateById(product1);
        product2.setPrice(product2.getPrice() - 30);
        productMapper.updateById(product2);
        Product product3 = productMapper.selectById(1);
        log.info("老板查询的商品价格为{}", product3.getPrice());
    }
}
