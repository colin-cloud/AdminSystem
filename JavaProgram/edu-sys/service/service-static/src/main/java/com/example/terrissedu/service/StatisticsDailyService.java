package com.example.terrissedu.service;

import com.example.terrissedu.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.vo.StatisticData;
import com.example.terrissedu.entity.vo.StatisticQuery;

import java.util.List;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    Integer countDailyRegisters(String date);

    List<StatisticsDaily> selectByQuery(StatisticQuery query);
}
