package com.mehdi.otp.Repository;

import com.mehdi.otp.Model.IP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRepository extends JpaRepository<IP,Long> {
    IP findByip(String ip);
}
