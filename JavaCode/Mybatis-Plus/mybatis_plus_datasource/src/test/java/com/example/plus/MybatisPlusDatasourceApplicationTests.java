package com.example.plus;

import com.example.plus.bean.Product;
import com.example.plus.bean.User;
import com.example.plus.service.ProductService;
import com.example.plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {
        User byId = userService.getById(1);
        System.out.println(byId);
        Product byId1 = productService.getById(1);
        System.out.println(byId1);
    }

}
