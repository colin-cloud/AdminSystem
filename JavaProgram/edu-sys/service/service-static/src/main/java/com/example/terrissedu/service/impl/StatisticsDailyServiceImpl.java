package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.client.StudentMemberClient;
import com.example.terrissedu.entity.StatisticsDaily;
import com.example.terrissedu.entity.vo.StatisticData;
import com.example.terrissedu.entity.vo.StatisticQuery;
import com.example.terrissedu.mapper.StatisticsDailyMapper;
import com.example.terrissedu.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily>
        implements StatisticsDailyService {

    @Autowired
    private StudentMemberClient memberClient;

    @Override
    public Integer countDailyRegisters(String date) {
        Integer res = memberClient.countDailyRegisters(date).getData()  ;
        // 查询数据库，看是否存在对象
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.eq("date_calculated", date);
        StatisticsDaily one = getOne(wrapper);

        if (one == null) {
            one = new StatisticsDaily();
            one.setDateCalculated(date);
        }
        // 更新信息
        one.setRegisterNum(res);

        // 存入数据库
        saveOrUpdate(one);

        return res;
    }

    @Override
    public List<StatisticsDaily> selectByQuery(StatisticQuery query) {

        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.between("date_calculated", query.getBegin(), query.getEnd())
                .select("date_calculated", query.getType())
                .orderByAsc("date_calculated");

        return list(wrapper);
    }
}
