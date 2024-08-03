package com.mehdi.other.architecture;

import com.mehdi.other.architecture.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081/users",name = "getuser")
public interface GetCurrentUser {

    @GetMapping("/getuser")
    public Users getUser();
}
