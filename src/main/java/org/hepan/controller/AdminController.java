package org.hepan.controller;


import com.github.pagehelper.PageInfo;
import org.hepan.VO.AdVO;
import org.hepan.VO.PageListVO;
import org.hepan.VO.ResultVO;
import org.hepan.dataobject.HepanAd;
import org.hepan.dataobject.HepanShowSetting;
import org.hepan.mapper.ShowSettingMapper;
import org.hepan.service.AdService;
import org.hepan.service.ShowSettingService;
import org.hepan.utils.PageInfoUtil;
import org.hepan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    ShowSettingService showSettingService;

    @Autowired
    AdService adService;

    @RequestMapping(value = "showset", method = RequestMethod.GET)
    public ResultVO showSet() {
        HepanShowSetting setting = showSettingService.getShowSetting();
        return ResultUtil.success(setting);
    }

    @RequestMapping(value = "showsetStore", method = RequestMethod.POST)
    public ResultVO updateSet(@Valid @RequestBody HepanShowSetting form) {
        showSettingService.setSetting(form);
        return ResultUtil.success( );
    }

    @RequestMapping(value = "adIndex", method = RequestMethod.GET)
    public ResultVO adIndex(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageInfo<AdVO> ads = adService.findeAll(page, size);
        PageListVO res = PageInfoUtil.setPageInfoUtil(ads);
        return ResultUtil.success(res);
    }
}
