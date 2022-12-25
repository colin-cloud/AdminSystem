package com.company.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Student {

    private String[] courses;
    private List<String> list;
    private Set<String> set;
    private List<Course> courseList;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    private Map<String, String> maps;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", set=" + set +
                ", courseList=" + courseList +
                ", maps=" + maps +
                '}';
    }
}
