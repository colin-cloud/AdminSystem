package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.CmsBanner;
import com.example.terrissedu.mapper.CmsBannerMapper;
import com.example.terrissedu.service.CmsBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class CmsBannerServiceImpl extends ServiceImpl<CmsBannerMapper, CmsBanner>
        implements CmsBannerService {

    @Override
    @Cacheable(key = "'listBanners'", value = "banner")
    public CommonResult<List<CmsBanner>> listFourBannersBySort() {
        QueryWrapper<CmsBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort")
                .last("limit 4");
        List<CmsBanner> res = list(wrapper);
        return new CommonResult<List<CmsBanner>>().success()
                .message(ResultMessage.UPDATE_BANNER_SUCCESS)
                .data(res);
    }
}
