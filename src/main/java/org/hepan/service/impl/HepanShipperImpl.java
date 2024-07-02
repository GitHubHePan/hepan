package org.hepan.service.impl;

import org.hepan.dataobject.HepanShipper;
import org.hepan.mapper.HepanShipperMapper;
import org.hepan.service.HepanShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HepanShipperImpl implements HepanShipperService {

    @Autowired
    HepanShipperMapper hepanShipperMapper;

    @Override
    public List<HepanShipper> getShippers(){
        List<HepanShipper> shippers = hepanShipperMapper.selectAll();
        return shippers;
    }

}
