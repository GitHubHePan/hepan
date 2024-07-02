package org.hepan.controller;

import org.hepan.VO.ChangeAdStatusVO;
import org.hepan.VO.ResultVO;
import org.hepan.dataobject.HepanAd;
import org.hepan.form.AdForm;
import org.hepan.service.AdService;
import org.hepan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/saleStatus", method = RequestMethod.POST)
    public ResultVO saleStatus(@RequestBody ChangeAdStatusVO map) {
        adService.updateAdStatus(map.getId(), map.getStatus());
        return ResultUtil.success();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResultVO saleStatus(@RequestParam Integer id) {
        HepanAd ad = adService.findById(id);
        return ResultUtil.success(ad);
    }


    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ResultVO saleStatus(@Valid @RequestBody AdForm adForm) {


        return ResultUtil.success(ad);
    }
}
