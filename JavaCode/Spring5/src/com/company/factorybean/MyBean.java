package com.company.factorybean;

import com.company.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MyBean implements FactoryBean<Course> {


    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
