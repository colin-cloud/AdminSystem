package com.company.test;

import com.company.collectiontype.Book;
import com.company.collectiontype.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小白学java
 * @version 3.0
 */
public class TestStu {


    @Test
    public void testStu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Student.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("stu.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
}
