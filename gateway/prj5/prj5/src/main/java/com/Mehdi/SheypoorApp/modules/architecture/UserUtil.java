package com.Mehdi.SheypoorApp.modules.architecture;

import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import com.Mehdi.SheypoorApp.modules.architecture.service.UsersService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

public class UserUtil {
   // private UsersRepository usersRepository;

//    public UserUtil(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }

    public  Users getCurrentuUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        Users users = new Users();
        users.setEmail(email);
     //   Users users =usersRepository.findByemail(email);
        //return users;
        return users;

    }
}
