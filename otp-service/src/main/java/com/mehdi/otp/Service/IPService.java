package com.mehdi.otp.Service;


import com.mehdi.otp.Model.IP;
import com.mehdi.otp.Repository.IPRepository;
import com.mehdi.otp.Utill.IPUtill;
import com.mehdi.otp.Utill.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class IPService {


    private OtpGenerator otpGenerator;
    public static boolean otpFlag;
    private IPRepository ipRepository;
    private IPUtill ipUtill = new IPUtill();
    private final int  OTP_DURATION = 180000;
    private final int  BLOCKED_TIME = 1000;
    private final int  MAX_REQ_NUM  =   4;

    @Autowired
    public IPService(IPRepository ipRepository) {
        otpGenerator = new OtpGenerator(ipRepository);
        this.ipRepository = ipRepository;
    }

    public IPService() {

    }

    @Transactional
    public boolean isBlock(){
        String ip = ipUtill.getIp();
        IP ip2 = ipRepository.findByip(ip);

        System.out.println("ip req is "+ip2.getReqNum());

        if (ip2.getReqNum()==MAX_REQ_NUM){
            System.out.println("reza");

            long cureentTime = new Date().getTime();
            ip2.setStartedBlockTime(cureentTime);
            ipRepository.save(ip2);
            //  ip2
            return  true;
        }
        else if (ip2.getReqNum()>MAX_REQ_NUM){
            return true;
        }


        return false;

    }

    @Transactional
    public boolean checkBlockTime(){

        String ip = ipUtill.getIp();
        IP ip2 = ipRepository.findByip(ip);
        long cureentTime = new Date().getTime();
        //Users users = userUtil.getCurrentuUser();
        System.out.println("bor");
        if(cureentTime-ip2.getStartedBlockTime()>BLOCKED_TIME){
//            System.out.println("blk tim is: "+startedBlockTime.get(0));
//            System.out.println("amd");
//            for (int i=0;i<startedBlockTime.size();i++)
//            {
//                startedBlockTime.remove(i);
//            }
            ip2.setStartedBlockTime(0L);
            ip2.setReqNum(0);
            ipRepository.save(ip2);
            otpGenerator.reqNumber = 0;
            return false;

        }
        return true;
    }

    public void ipProcess(){

        String ip = ipUtill.getIp();
        IP ip1 = ipRepository.findByip(ip);
        ip1 .setReqNum(0);
        ipRepository.save(ip1);

    }




    public Object registerOtp(IP ip , String sendedOTP){
        long currentTime = new Date().getTime();
        long lastTime = ipRepository.findByip(ipUtill.getIp()).getCreatedAt();
        String databaseOTP = ipRepository.findByip(ipUtill.getIp()).getOtpCode();
        String decodedOTP= Integer.toString((Integer.parseInt(databaseOTP)+13)/89);


        if (currentTime-lastTime>OTP_DURATION) {
            System.out.println(22);
            //otpGenerator.otp= otpGenerator.otpGenerator();

            return "Time out";
        }

        else if(sendedOTP.equals(decodedOTP)){
            //System.out.println("barabare");
            otpFlag=true;
            return "otp is correct";

        }



        else
            otpFlag=false;
            return "otp is not correct";
    }
}
