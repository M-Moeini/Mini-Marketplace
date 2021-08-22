package com.mehdi.otp.Utill;

import com.mehdi.otp.Model.IP;
import com.mehdi.otp.Repository.IPRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;

public class OtpGenerator {

    //private UsersRepository usersRepository;
    private IPRepository ipRepository;
   // private UserUtil UserUtil ;
    public static int     otp;
    public static int     reqNumber=0;
    public static long    currentTime;
    private IPUtill ipUtill = new IPUtill();
    public IP ip1 = new IP();





    public OtpGenerator(IPRepository ipRepository) {
       // this.usersRepository = usersRepository;
        this.ipRepository = ipRepository;
       // UserUtil= new UserUtil(usersRepository);

    }

    public OtpGenerator() {

    }


    public int otpGenerator(){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        System.out.println(otp);
        return otp;
    }


    @Transactional
    public int otpManage(){
        reqNumber++;
        //Users users = UserUtil.getCurrentuUser(usersRepository);
        String ip = ipUtill.getIp();

        System.out.println(ip);
        // IP ip2 = ipRepository.findByip(ip);
        //  System.out.println("Ip2 is :"+ip2.getIp());
        System.out.println("Ip1 is :" + ip);


        if (ipRepository.findByip(ip)==null){
            ip1.setReqNum(reqNumber);
            ip1.setIp(ip);
            // ipRepository.save(ip1);
            otp = otpGenerator();
            currentTime = new Date().getTime();
            System.out.println(currentTime);
            ip1.setOtpCode(Integer.toString(otp*89 -13));

            ip1.setCreatedAt(currentTime);
            ipRepository.save(ip1);
            return otp;
        }
        else{
            ipRepository.findByip(ip).setReqNum(reqNumber);
            System.out.println("resid");

            otp = otpGenerator();
            currentTime = new Date().getTime();
            System.out.println(currentTime);

            ipRepository.findByip(ip).setOtpCode(Integer.toString(otp*89 -13));
            ipRepository.findByip(ip).setCreatedAt(currentTime);
            ipRepository.save(ipRepository.findByip(ip));
            return otp;

        }
        //ip1.setIp(ip);




        //users.setReqNum(reqNumber);


    }

}

