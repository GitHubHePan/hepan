package org.hepan.repository;

import org.hepan.dataobject.HepanUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HepanUserRepository extends JpaRepository<HepanUser, String> {

}
