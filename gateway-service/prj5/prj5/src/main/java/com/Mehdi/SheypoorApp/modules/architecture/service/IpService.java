package com.Mehdi.SheypoorApp.modules.architecture.service;

import com.Mehdi.SheypoorApp.modules.architecture.IpUtill;
import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import com.Mehdi.SheypoorApp.modules.architecture.repository.IpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IpService {
//
//    public static boolean otpFlag;
//    private IpRepository ipRepository;
//    private IpUtill ipUtill = new IpUtill();
//    private final int  OTP_DURATION = 180000;
//
//    @Autowired
//    public IpService(IpRepository ipRepository) {
//        this.ipRepository = ipRepository;
//    }
//
//    public IpService() {
//
//    }
//
//    public Object registerOtp(IP ip ,String sendedOTP){
//        long currentTime = new Date().getTime();
//        long lastTime = ipRepository.findByip(ipUtill.getIp()).getCreatedAt();
//        String databaseOTP = ipRepository.findByip(ipUtill.getIp()).getOtpCode();
//        String decodedOTP= Integer.toString((Integer.parseInt(databaseOTP)+13)/89);
//
//
//            if (currentTime-lastTime>OTP_DURATION) {
//            System.out.println(22);
//            //otpGenerator.otp= otpGenerator.otpGenerator();
//
//            return "Time out";
//            }
//
//        else if(sendedOTP.equals(decodedOTP)){
//            //System.out.println("barabare");
//            otpFlag=true;
//            return "otp is correct";
//
//        }
//
//
//
//        else
//        return "otp is not correct";
//    }

}
