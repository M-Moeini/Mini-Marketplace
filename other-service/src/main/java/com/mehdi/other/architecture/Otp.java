package com.mehdi.other.architecture;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8082/otp",name = "response")
public interface Otp {

    @GetMapping("/res")
    public boolean otpRes();

    @GetMapping("/ip")
    public void ipProcess();

    @PostMapping("/setflag")
    public void setFlag(@RequestBody String flag);

}
