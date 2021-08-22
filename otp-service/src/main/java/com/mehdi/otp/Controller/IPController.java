package com.mehdi.otp.Controller;


import com.mehdi.otp.Model.IP;
import com.mehdi.otp.Repository.IPRepository;
import com.mehdi.otp.Service.IPService;
import com.mehdi.otp.Utill.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.io.IOException;

import static com.mehdi.otp.Service.IPService.otpFlag;

//import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.IP;

@RestController
@RequestMapping("/otp")
public class IPController {


    private OtpGenerator otpGenerator = new OtpGenerator();
    //private MACutill maCutill = new MACutill();
    private  IP ip = new IP();
    public static String sendedOTP;
    private IPService ipService;




    @Autowired
    public IPController(IPRepository ipRepository, IPService ipService) {
        this.ipService = ipService;
        otpGenerator=new OtpGenerator(ipRepository);




    }







    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @Transactional
    public Object otpGen() throws InterruptedException, IOException {
        //System.out.println("reqbody"+x);
        //otpFlag=false;
        int otp = otpGenerator.otpManage();
        System.out.println("addd");

        //maCutill.getMAC();




        if(!ipService.isBlock()){
//            System.out.println("amadam");
//            ip.setOtpCode(Integer.toString(otp));

            return otp;


        }
        else {
            ipService.checkBlockTime();
            System.out.println("llll");
            return "you are blocked";

        }











//        smsService.send(SmsRequest.builder()
//                .username("9128214053")
//                .password("P@$$w0rd93")
//                .from("500010001422")
//                .to("09026473264")
//                .text(Integer.toString(otp))
//                .isFlash(false)
//                .build());


    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    @Transactional
    public Object registerOtp(@RequestBody IP ip){

        sendedOTP = ip.getOtpCode();

        System.out.println("sended otp is :"+sendedOTP);


        return this.ipService.registerOtp(ip,sendedOTP);






    }


    @RequestMapping(value = "/res",method = RequestMethod.GET)
    @Transactional
    public boolean otpRes(){
        return otpFlag;
    }

    @RequestMapping(value = "setflag",method = RequestMethod.POST)
    public void setFlag(@RequestBody String flag){
        if (flag.equals("false")){
            otpFlag=false;

        }
    }

    @RequestMapping(value ="/ip",method = RequestMethod.GET)
    @Transactional
    public void ipProcess(){
        ipService.ipProcess();
    }

}