package org.hepan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanUser;
import org.hepan.repository.HepanUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthServiceImplTest {
    @Autowired
    private  AuthServiceImpl authService;

    @Test
    public void findById(){
        HepanUser user = authService.findByUserId("hepan");
        log.info(user.toString());
    }
}