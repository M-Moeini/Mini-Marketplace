package com.mehdi.other.architecture.service;

import com.mehdi.other.architecture.Otp;
import com.mehdi.other.architecture.UserUtil;
import com.mehdi.other.architecture.controller.UsersController;
import com.mehdi.other.architecture.enums.Roles;
import com.mehdi.other.architecture.model.Users;
import com.mehdi.other.architecture.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsersService {


    private UsersRepository usersRepository;
   // private IpRepository ipRepository;
    private UsersController usersController ;
   // private OtpGenerator otpGenerator;
    private UserUtil userUtil;
    public boolean otpF=false;

    //private final int  BLOCKED_TIME = 86400000;
    private final int  BLOCKED_TIME = 15000;
    private final int  MAX_REQ_NUM  =   4;
    private ArrayList<Long> startedBlockTime = new ArrayList<Long>();


    //  public IP ip = new IP();
   // public IpUtill ipUtill = new IpUtill();





    public UsersService(){

    }

    @Autowired
    private Otp otp;






    @Autowired
    public UsersService(UsersRepository usersRepository) {
        //otpGenerator = new OtpGenerator(usersRepository,ipRepository);
        userUtil     = new UserUtil(usersRepository);
        this.usersRepository = usersRepository;
    }

//    @Autowired
//    public void service(IpRepository ipRepository){
//        this.ipRepository = ipRepository;
//    }





    @Transactional
    public Object registerUser(Users users)  {
        System.out.println("llllllllllllllllllllllll");

        System.out.println("otp res is "+ otp.otpRes());

            if ( otp.otpRes()){
                System.out.println("hey man");
                //otpGenerator.otp= otpGenerator.otpGenerator();
//            System.out.println("oto is "+otpGenerator.otp);
//            String ip = ipUtill.getIp();
//            IP ip1 = ipRepository.findByip(ip);
//            ip1 .setReqNum(0);
//            ipRepository.save(ip1);
                otp.ipProcess();

                System.out.println("hear1");
                otp.setFlag("false");
                System.out.println("hear2");


                return  this.usersRepository.save(users);

            }




        //  ipUtill.getIp();

        //Users users1 = userUtil.getCurrentuUser();

        //System.out.println("my otp:"+otp);
//        long currentTime = new Date().getTime();
//        long lastTime = ipRepository.findByip(ipUtill.getIp()).getCreatedAt();
//        System.out.println(currentTime);
//        System.out.println(2);
//       // System.out.println("opo is :"+Integer.parseInt(users.getOtpCode()));
//        System.out.println("opo is :"+ otpGenerator.otp);
//
//            if(currentTime-lastTime>OTP_DURATION){
//                System.out.println(22);
//                otpGenerator.otp= otpGenerator.otpGenerator();
//
//                return "Time out";
//
//            }


        System.out.println("hear3");
        return "bad";




    }


    public Page<Users> findAllUsers(String page, String size, String sort){

        return this.usersRepository.findAll(PageRequest.of(Integer.parseInt(page),
                Integer.parseInt(size),
                Sort.by(sort)));
    }


    @Transactional
    public Users makeUserEnable(Users users){
        String email = users.getEmail();
        List<Roles> roles = users.getRoles();

        // System.out.println("jhkj");

        Users users1= usersRepository.findByemail(email);
        users1.setRoles(roles);
        return users1;



    }

}