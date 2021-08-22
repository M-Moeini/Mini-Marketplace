package com.Mehdi.SheypoorApp.modules.architecture;

import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8084/users",name = "users")
public interface User {

    @GetMapping("")
    public Page<Users> getUser(@RequestParam(value = "page") String  page,
                              @RequestParam(value = "size") String  size,
                              @RequestParam(value="sort") String sort);

    @PostMapping("/register")
    public Object registerUser(@RequestBody Users users);


    @PostMapping("/enableUser")
    public Users makeUserEnable(@RequestBody Users users);

}
