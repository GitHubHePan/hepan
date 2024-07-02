package org.hepan.controller;


import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.hepan.VO.PageListVO;
import org.hepan.VO.RegionVO;
import org.hepan.VO.ResultVO;
import org.hepan.dataobject.HepanOrder;
import org.hepan.dataobject.HepanSetting;
import org.hepan.dataobject.HepanShipper;
import org.hepan.service.HapenOrderService;
import org.hepan.service.HepanRegionService;
import org.hepan.service.HepanShipperService;
import org.hepan.service.UserSettingService;
import org.hepan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {


    @Autowired
    HapenOrderService hepanOrderService;

    @Autowired
    UserSettingService userSettingService;

    @Autowired
    HepanShipperService hepanShipperService;

    @Autowired
    HepanRegionService hepanRegionService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResultVO index(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                          @RequestParam(value = "orderSn", defaultValue = "") String orderSn,
                          @RequestParam(value = "consignee", defaultValue = "") String consignee,
                          @RequestParam(value = "logistic_code", defaultValue = "") String logistic_code,
                          @RequestParam(value = "status", defaultValue = "") List<String> status
                          ) {
        PageListVO pageListVO = new PageListVO();
        PageInfo<HepanOrder> pagelist =  hepanOrderService.findHapenOrders(page, size, orderSn, consignee, status);
        pageListVO.setTotalPage(pagelist.getPages());
        pageListVO.setCurrentPage(pagelist.getPageNum());
        pageListVO.setPageSize(pagelist.getSize());
        pageListVO.setData(pagelist.getList());
        pageListVO.setCount(pagelist.getTotal());
        return ResultUtil.success(pageListVO);

    }

    @RequestMapping(value = "/getAutoStatus", method = RequestMethod.GET)
    public ResultVO getAutoStatus() {
        HepanSetting settingData = userSettingService.getSettingById();
        return ResultUtil.success(settingData.getAutoDelivery());
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.GET)
    public ResultVO getDeliverys() {
        List<HepanShipper> shippersData = hepanShipperService.getShippers();
        return ResultUtil.success(shippersData);
    }

    @RequestMapping(value = "/getAllRegion", method = RequestMethod.GET)
    public ResultVO getAllRegion() {
        List<RegionVO> regionData = hepanRegionService.getRegions();
        return ResultUtil.success(regionData);
    }
}
