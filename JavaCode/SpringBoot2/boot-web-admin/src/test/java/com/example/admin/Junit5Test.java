package com.example.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

/**
 * @author 小白学java
 * @version 3.0
 */
@DisplayName("Junit5测试功能类")
@Slf4j
public class Junit5Test {


    public int cal(int i, int j) {
        int res = i + j;
        return res;
    }

    @DisplayName("测试简单断言")
    @Test
    public void testAssert() {
        int cal = cal(2, 3);
        Assertions.assertEquals(5, cal, "不符合业务逻辑计算结果~");
        Object obj1 = new Object();
        Object obj2 = new Object();
        Assertions.assertSame(obj1, obj2, "两个对象不相同~");
    }

    @Disabled
    @DisplayName("测试displayName注解")
    @Test
    public void testDisplayName() {
        log.info("尝试displayName");
    }

    @BeforeEach
    public void testBeforeEach() {
        log.info("测试就要开始了~~~");
    }

    @AfterEach
    public void testAfterEach() {
        log.info("测试结束啦~~~");
    }

    @BeforeAll
    public static void testBeforeAll() {
        log.info("只运行一次的测试开始结果~");
    }

    @AfterAll
    public static void testAfterAll() {
        log.info("只运行一次的测试结束结果~");
    }
}
