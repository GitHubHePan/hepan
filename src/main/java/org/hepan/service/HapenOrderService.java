package org.hepan.service;

import com.github.pagehelper.PageInfo;
import org.hepan.dataobject.HepanOrder;

import java.util.List;

public interface HapenOrderService {
    Integer countHapenOrders();

    PageInfo<HepanOrder> findHapenOrders(Integer page, Integer size, String orderSn, String consignee, List<String> status);

}
