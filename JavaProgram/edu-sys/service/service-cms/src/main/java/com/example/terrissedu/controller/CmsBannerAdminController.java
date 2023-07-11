package com.example.terrissedu.controller;


import com.example.terrissedu.entity.CmsBanner;
import com.example.terrissedu.service.CmsBannerService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 后台
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/cms-service/cms-banner-admin")
@CrossOrigin
public class CmsBannerAdminController {

    @Autowired
    private CmsBannerService bannerService;

    @PostMapping("/insertBanner")
    @ApiOperation("添加banner")
    public CommonResult<CmsBanner> insertBanner(CmsBanner banner) {
        CommonResult<CmsBanner> res = new CommonResult<>();
        boolean save = bannerService.save(banner);
        if (save) {
            res.success(ResultMessage.INSERT_BANNERS_SUCCESS, banner);
        } else {
            res.error(ResultMessage.INSERT_BANNERS_ERROR);
        }
        return res;
    }

    @DeleteMapping("/removeBannerById/{id}")
    @ApiOperation("删除banner")
    public CommonResult<Boolean> removeBannerById(@PathVariable("id") Long id) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean save = bannerService.removeById(id);
        if (save) {
            res.success(ResultMessage.DELETE_BANNER_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_BANNER_ERROR);
        }
        return res;
    }

    @PutMapping("/updateBanner")
    @ApiOperation("更新banner")
    public CommonResult<Boolean> updateBanner(@RequestBody CmsBanner banner) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean save = bannerService.updateById(banner);
        if (save) {
            res.success(ResultMessage.UPDATE_BANNER_SUCCESS, true);
        } else {
            res.error(ResultMessage.UPDATE_BANNER_ERROR);
        }
        return res;
    }

    @GetMapping("/getBannerById")
    @ApiOperation("根据id查询banner")
    public CommonResult<CmsBanner> getBannerById(@RequestParam("id") Long id) {
        CommonResult<CmsBanner> res = new CommonResult<>();
        CmsBanner banner = bannerService.getById(id);
        if (banner != null) {
            res.success(ResultMessage.UPDATE_BANNER_SUCCESS, banner);
        } else {
            res.error(ResultMessage.UPDATE_BANNER_ERROR);
        }
        return res;
    }

    @GetMapping("/getBanners")
    @ApiOperation("获取所有的banner")
    public CommonResult<List<CmsBanner>> getBanners() {
        CommonResult<List<CmsBanner>> res = new CommonResult<>();
        List<CmsBanner> banners = bannerService.list(null);
        if (banners != null) {
            res.success(ResultMessage.UPDATE_BANNER_SUCCESS, banners);
        } else {
            res.error(ResultMessage.UPDATE_BANNER_ERROR);
        }
        return res;
    }
}

