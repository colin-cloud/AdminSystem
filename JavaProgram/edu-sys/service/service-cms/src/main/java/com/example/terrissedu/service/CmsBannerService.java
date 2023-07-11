package com.example.terrissedu.service;

import com.example.terrissedu.entity.CmsBanner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.utils.CommonResult;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface CmsBannerService extends IService<CmsBanner> {
    CommonResult<List<CmsBanner>> listFourBannersBySort();
}
