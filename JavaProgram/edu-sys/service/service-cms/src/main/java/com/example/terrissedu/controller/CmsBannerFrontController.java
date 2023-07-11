package com.example.terrissedu.controller;

import com.example.terrissedu.entity.CmsBanner;
import com.example.terrissedu.service.CmsBannerService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/cms-service/cms-banner-front")
@CrossOrigin
public class CmsBannerFrontController {

    @Autowired
    private CmsBannerService bannerService;

    @GetMapping("/getBanners")
    @ApiOperation("获取4个的banner")
    public CommonResult<List<CmsBanner>> getBanners() {
        return bannerService.listFourBannersBySort();
    }
}
