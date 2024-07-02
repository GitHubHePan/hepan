package org.hepan.controller;

import org.hepan.VO.IndexVO;
import org.hepan.VO.ResultVO;
import org.hepan.service.HapenOrderService;
import org.hepan.service.HepanGoods;
import org.hepan.service.HepanUserService;
import org.hepan.service.UserSettingService;
import org.hepan.service.impl.HepanOrderServiceImpl;
import org.hepan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class DashbordController {

    @Autowired
    private HepanGoods hepanGoods;

    @Autowired
    private HapenOrderService hepanOrderService;

    @Autowired
    private HepanUserService hepanUserService;

    @Autowired
    private UserSettingService userSettingService;

    @RequestMapping(value = "/index",  method = RequestMethod.GET)
    public ResultVO index() {
        Integer countOnSale = hepanGoods.countGoodOnSale();
        Integer countOrder = hepanOrderService.countHapenOrders();
        Integer countUser = hepanUserService.countUser();
        Integer countDown = userSettingService.settingCountDown();
        IndexVO indexVO = new IndexVO();
        indexVO.setGoodsOnsale(countOnSale);
        indexVO.setOrderToDelivery(countOrder);
        indexVO.setUser(countUser);
        indexVO.setTimestamp(countDown);

        return ResultUtil.success(indexVO);
    }

}


