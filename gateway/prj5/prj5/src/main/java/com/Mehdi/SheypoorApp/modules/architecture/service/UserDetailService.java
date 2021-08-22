package com.Mehdi.SheypoorApp.modules.architecture.service;

import com.Mehdi.SheypoorApp.enums.Roles;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("email"+ email);

        Users users = usersRepository.findByemail(email);
        System.out.println("email is :"+ users.getEmail());
        List<Roles> roles = users.getRoles();
         List<GrantedAuthority> grantedAuthorities=roles.stream().map((ga)-> new SimpleGrantedAuthority( ga.name())).collect(Collectors.toList());

        if(users==null){
            throw new UsernameNotFoundException("user not found");

        }

        User user = new User(users.getEmail(), users.getPassword(),  grantedAuthorities);
        return user;




    }
}
