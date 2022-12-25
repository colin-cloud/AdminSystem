package com.example.admin.service;

import com.example.admin.bean.City;
import com.example.admin.mapper.CityMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    Counter counter;

    public CityService(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("cityService.insert.count");
    }

    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }

    public List<City> getCities() {
        return cityMapper.getCities();
    }

    public void insert(City city) {
        counter.increment();//增加次数
        cityMapper.saveCity(city);
    }
}
