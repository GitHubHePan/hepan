package org.hepan.repository;

import lombok.extern.slf4j.Slf4j;
import org.hepan.dataobject.HepanUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HepanUserRepositoryTest {

    @Autowired
    private HepanUserRepository hepanUserRepository;

    @Test
    public void findAll() {
        List<HepanUser> users = hepanUserRepository.findAll();
        log.info(users.toString());
    }
}