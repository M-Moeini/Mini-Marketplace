package com.Mehdi.SheypoorApp.modules.architecture.repository;

import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpRepository  extends JpaRepository<IP,Long> {

    IP findByip(String ip);
}
