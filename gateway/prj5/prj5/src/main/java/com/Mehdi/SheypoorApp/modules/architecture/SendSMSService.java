package com.Mehdi.SheypoorApp.modules.architecture;


//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "sms", url = "https://rest.payamak-panel.com/api/SendSMS/SendSMS")
public interface SendSMSService {

    @PostMapping
    Void send(@RequestBody SmsRequest request);
}
