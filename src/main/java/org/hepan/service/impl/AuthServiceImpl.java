package org.hepan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanUser;
import org.hepan.enums.ResEnums;
import org.hepan.exception.SysException;
import org.hepan.repository.HepanUserRepository;
import org.hepan.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private HepanUserRepository hepanUserRepository;

    @Override
    public HepanUser findByUserId(String id){

        Optional<HepanUser> userOptional = hepanUserRepository.findById(id);
        try {
            HepanUser user = userOptional.get();
            return user;
        } catch (Exception e) {
            throw new SysException(ResEnums.USER_NOT_FOUND);
        }
    };

}
