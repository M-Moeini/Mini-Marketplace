package com.Mehdi.SheypoorApp.modules.architecture.controller;

import com.Mehdi.SheypoorApp.modules.architecture.MACutill;
import com.Mehdi.SheypoorApp.modules.architecture.Otp;
import com.Mehdi.SheypoorApp.modules.architecture.OtpGenerator;
import com.Mehdi.SheypoorApp.modules.architecture.SendSMSService;
import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import com.Mehdi.SheypoorApp.modules.architecture.repository.IpRepository;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import com.Mehdi.SheypoorApp.modules.architecture.service.IpService;
import com.Mehdi.SheypoorApp.modules.architecture.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class IPController {

    private UsersService usersService;
    private OtpGenerator otpGenerator = new OtpGenerator();
    private MACutill maCutill = new MACutill();
    private IP ip = new IP();
    public static String sendedOTP;
    private IpService ipService;
    public static String otpRes ;






//
//    @Autowired
//    public IPController(UsersService usersService, UsersRepository usersRepository,
//                        IpRepository ipRepository, IpService ipService, Otp otp) {
//        this.ipService = ipService;
//        this.usersService = usersService;
//        otpGenerator=new OtpGenerator(usersRepository,ipRepository);
//
//
//        this.otp = otp;
//    }



    @Autowired
    private Otp otp;








    @RequestMapping(value = "/get",method = RequestMethod.GET)

    public Object otpGen() {


        System.out.println(otp.getotp());

//        int otp = otpGenerator.otpManage();
//        System.out.println("addd");
//
//        //maCutill.getMAC();
//
//
//
//
//        if(!usersService.isBlock()){
////            System.out.println("amadam");
////            ip.setOtpCode(Integer.toString(otp));
//
//            return otp;
//
//
//        }
//        else {
//            usersService.checkBlockTime();
//            System.out.println("llll");
//            return "you are blocked";
//
//        }
//
//
//
//
//
//
//
//
//
//
//
////        smsService.send(SmsRequest.builder()
////                .username("9128214053")
////                .password("P@$$w0rd93")
////                .from("500010001422")
////                .to("09026473264")
////                .text(Integer.toString(otp))
////                .isFlash(false)
////                .build());
//



        return otp.getotp();
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)

    public Object registerOtp(@RequestBody IP ip){
        // sendedOTP = ip.getOtpCode();
//
//        System.out.println("sended otp is :"+sendedOTP);
//
//
      //  return this.ipService.registerOtp(ip,sendedOTP);
//
//
//
//
//
        otpRes = otp.sendotp(ip);
        return otpRes;


        //return ip;
    }


}
