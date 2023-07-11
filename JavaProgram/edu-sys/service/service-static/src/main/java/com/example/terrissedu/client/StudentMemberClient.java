package com.example.terrissedu.client;

import com.example.terrissedu.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Terriss
 * @time 2023-07-09 22:02:55
 * @description TODO
 */
@FeignClient("service-user")
@Component
public interface StudentMemberClient {

    @GetMapping("/user-service/student-member/countDailyRegisters/{date}")
    CommonResult<Integer> countDailyRegisters(@PathVariable("date") String date);
}
