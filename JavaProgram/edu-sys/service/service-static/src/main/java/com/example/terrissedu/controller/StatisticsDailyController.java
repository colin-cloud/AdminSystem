package com.example.terrissedu.controller;


import com.example.terrissedu.entity.StatisticsDaily;
import com.example.terrissedu.entity.vo.StatisticData;
import com.example.terrissedu.entity.vo.StatisticQuery;
import com.example.terrissedu.service.StatisticsDailyService;
import com.example.terrissedu.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@RestController
@CrossOrigin
@Api(tags = "统计量")
@RequestMapping("/static-service/statistics-daily")
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService dailyService;

    @PostMapping("/countDailyRegisters/{date}")
    @ApiOperation("统计某一天的注册人数")
    public CommonResult<Integer> countDailyRegisters(@PathVariable("date") String date) {
        Integer res = dailyService.countDailyRegisters(date);
        return new CommonResult<Integer>().success().message("统计" + date + "当天的注册人数")
                .data(res);
    }

    @PostMapping("/getDataByType")
    @ApiOperation("统计某一天的注册人数")
    public CommonResult<StatisticData> getDataByType(@RequestBody StatisticQuery query) {
        List<StatisticsDaily> data = dailyService.selectByQuery(query);
        StatisticData res = new StatisticData(new ArrayList<>(), new ArrayList<>());
        data.forEach(sd -> {
            res.getDates().add(sd.getDateCalculated());
            switch (query.getType()) {
                case "register_num":
                    res.getData().add(sd.getRegisterNum());
                    break;
                case "login_num":
                    res.getData().add(sd.getLoginNum());
                    break;
                case "video_view_num":
                    res.getData().add(sd.getVideoViewNum());
                    break;
                case "course_num":
                    res.getData().add(sd.getCourseNum());
                    break;
            }
        });
        return new CommonResult<StatisticData>().success()
                .data(res);
    }
}

