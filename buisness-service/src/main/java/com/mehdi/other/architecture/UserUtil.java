package com.mehdi.other.architecture;

import com.mehdi.other.architecture.model.Users;
import com.mehdi.other.architecture.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Optional;

public class UserUtil {
    private UsersRepository usersRepository;

    @Autowired
    public UserUtil(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users getCurrentuUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Users users =usersRepository.findByemail(email);
        return users;

    }
}