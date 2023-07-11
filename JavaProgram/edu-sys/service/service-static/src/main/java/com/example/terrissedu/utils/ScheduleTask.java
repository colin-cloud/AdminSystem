package com.example.terrissedu.utils;

import com.example.terrissedu.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Terriss
 * @time 2023-07-10 08:31:07
 * @description TODO
 */
@Component
public class ScheduleTask {

    @Autowired
    private StatisticsDailyService dailyService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void doTask() {
        String date = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        dailyService.countDailyRegisters(date);
    }
}
