package com.example.terrissedu.client;


import com.example.terrissedu.utils.dto.MemberDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-user")
public interface StudentMemberClient {

    @GetMapping("/user-service/student-member/getMemberById/{id}")
    MemberDTO getMemberById(@PathVariable("id") String id);
}
