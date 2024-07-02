package org.hepan.service;

import org.hepan.dataobject.HepanUser;

public interface AuthService {
    HepanUser findByUserId(String username);
}
