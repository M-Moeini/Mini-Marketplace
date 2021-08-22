package com.mehdi.other.architecture.repository;

import com.mehdi.other.architecture.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {


    Users findByemail(String email);

    Users deleteByemail(String email);


}
