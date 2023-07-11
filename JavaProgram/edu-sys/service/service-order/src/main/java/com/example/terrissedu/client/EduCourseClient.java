package com.example.terrissedu.client;

import com.example.terrissedu.utils.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Terriss
 * @time 2023-07-08 18:59:50
 * @description TODO
 */
@Component
@FeignClient("service-edu")
public interface EduCourseClient {

    @GetMapping("/edu-service/edu-course/getCourseByCourseId/{courseId}")
    CourseDTO getCourseByCourseId(@PathVariable("courseId") Long courseId);
}
