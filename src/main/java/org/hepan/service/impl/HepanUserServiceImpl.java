package org.hepan.service.impl;

import org.hepan.dataobject.HepanUser;
import org.hepan.mapper.HepanUserMapper;
import org.hepan.service.HepanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HepanUserServiceImpl implements HepanUserService {

    @Autowired
    HepanUserMapper hepanUserMapper;

    @Override
    public Integer countUser() {
        return hepanUserMapper.countUser();
    }
}
