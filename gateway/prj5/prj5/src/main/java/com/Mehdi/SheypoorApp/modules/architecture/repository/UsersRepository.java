package com.Mehdi.SheypoorApp.modules.architecture.repository;

import com.Mehdi.SheypoorApp.modules.architecture.model.Posts;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {


    Users findByemail(String email);

     Users deleteByemail(String email);


}
