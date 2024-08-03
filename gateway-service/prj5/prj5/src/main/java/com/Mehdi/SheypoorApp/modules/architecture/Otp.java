package com.Mehdi.SheypoorApp.modules.architecture;


import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8082/otp",name = "kjdsk")
public interface Otp {

    @GetMapping("/get")
    public String getotp( );

    @PostMapping("/send")
    public String sendotp(@RequestBody IP ip);


}
