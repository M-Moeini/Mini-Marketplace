package com.Mehdi.SheypoorApp.modules.architecture.service;


import com.Mehdi.SheypoorApp.enums.Roles;
import com.Mehdi.SheypoorApp.modules.architecture.IpUtill;
import com.Mehdi.SheypoorApp.modules.architecture.OtpGenerator;
import com.Mehdi.SheypoorApp.modules.architecture.controller.IPController;
import com.Mehdi.SheypoorApp.modules.architecture.controller.UsersController;
import com.Mehdi.SheypoorApp.modules.architecture.UserUtil;
import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
import com.Mehdi.SheypoorApp.modules.architecture.repository.IpRepository;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.Mehdi.SheypoorApp.modules.architecture.controller.IPController.otpRes;
import static com.Mehdi.SheypoorApp.modules.architecture.controller.IPController.sendedOTP;
//import static com.Mehdi.SheypoorApp.modules.architecture.service.IpService.otpFlag;

@Service
public class  UsersService {


   // private UsersRepository usersRepository;
    private IpRepository ipRepository;
    private UsersController usersController ;
    private OtpGenerator otpGenerator;
    private UserUtil userUtil;

    //private final int  BLOCKED_TIME = 86400000;
    private final int  BLOCKED_TIME = 15000;
    private final int  MAX_REQ_NUM  =   4;
    private ArrayList<Long> startedBlockTime = new ArrayList<Long>();
  //  public IP ip = new IP();
    public IpUtill ipUtill = new IpUtill();





    public UsersService(){

    }



//    @Autowired
//    public UsersService(UsersRepository usersRepository,IpRepository ipRepository) {
//        otpGenerator = new OtpGenerator(usersRepository,ipRepository);
//        userUtil     = new UserUtil(usersRepository);
//        this.usersRepository = usersRepository;
//    }

//    @Autowired
//    public void service(IpRepository ipRepository){
//        this.ipRepository = ipRepository;
//    }





    @Transactional
    public Object registerUser(Users users)  {

      //  ipUtill.getIp();

        Users users1 = userUtil.getCurrentuUser();

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


             if (otpRes.equals("otp is correct")){
                System.out.println("hey man");
                otpGenerator.otp= otpGenerator.otpGenerator();
                System.out.println("oto is "+otpGenerator.otp);
                String ip = ipUtill.getIp();
                IP ip1 = ipRepository.findByip(ip);
                ip1 .setReqNum(0);
                ipRepository.save(ip1);
               // otpFlag=false;
                 otpRes="";

               // return this.usersRepository.save(users);

            }



        System.out.println(33);
            return "";

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



    public Page<Users> findAllUsers(String page, String size, String sort){

//        return this.usersRepository.findAll(PageRequest.of(Integer.parseInt(page),
//                Integer.parseInt(size),
//                Sort.by(sort)));
        return null;
    }


    @Transactional
    public Users makeUserEnable(Users users){
        String email = users.getEmail();
        List<Roles> roles = users.getRoles();

       // System.out.println("jhkj");

//        Users users1= usersRepository.findByemail(email);
//        users1.setRoles(roles);
//        return users1;
        return null;



    }

}
