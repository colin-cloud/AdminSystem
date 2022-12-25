package com.example.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {

    @Select("select * from city where id = #{id}")
    public City getCityById(Integer id);

    @Select("select * from city")
    public List<City> getCities();

//    @Insert("insert into city (name, state, country) values (#{name}, #{state}, #{country})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void saveCity(City city);
}
