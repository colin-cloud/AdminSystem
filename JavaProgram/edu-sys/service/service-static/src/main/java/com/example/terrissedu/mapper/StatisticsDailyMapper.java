package com.example.terrissedu.mapper;

import com.example.terrissedu.entity.StatisticsDaily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.terrissedu.entity.vo.StatisticQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 网站统计日数据 Mapper 接口
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Mapper
public interface StatisticsDailyMapper extends BaseMapper<StatisticsDaily> {

}
