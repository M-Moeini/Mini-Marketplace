package com.Mehdi.SheypoorApp.modules.architecture.controller;

import com.Mehdi.SheypoorApp.modules.architecture.MACutill;
import com.Mehdi.SheypoorApp.modules.architecture.OtpGenerator;
import com.Mehdi.SheypoorApp.modules.architecture.User;
import com.Mehdi.SheypoorApp.modules.architecture.UserUtil;
import com.Mehdi.SheypoorApp.modules.architecture.model.IP;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import com.Mehdi.SheypoorApp.modules.architecture.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
public class UsersController {

    //private final   SendSMSService smsService;
    public   UsersService usersService = new UsersService();
    private OtpGenerator otpGenerator;
    private MACutill maCutill = new MACutill();
    private IP ip = new IP();

    @Autowired
    private User user;











    @Autowired
    public UsersController(UsersService usersService
                          ) {
        this.usersService = usersService;
      //  otpGenerator=new OtpGenerator(usersRepository,ipRepository);

    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Page<Users> getUser(@RequestParam(value = "page") String  page,
                              @RequestParam(value = "size") String  size,
                              @RequestParam(value="sort") String sort){




       // return this.usersService.findAllUsers(page,size,sort);

        return user.getUser(page, size, sort);
    }

    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    @Transactional
    public Object registerUser(@RequestBody  Users users)  {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        String email = authentication.getName();
        //System.out.println(otp);
       // System.out.println("otpcode is this"+ip.getOtpCode());

       // return this.usersService.registerUser(users);

        return user.registerUser(users);
    }

//
//    @RequestMapping(value = "/otpGen",method = RequestMethod.GET)
//    @Transactional
//    public Object otpGen() throws InterruptedException, IOException {
//
//        int otp = otpGenerator.otpManage();
//        System.out.println("addd");
//
//        maCutill.getMAC();
//
//
//
//
//        if(!usersService.isBlock()){
//            System.out.println("amadam");
//            ip.setOtpCode(Integer.toString(otp));
//
//            return otp;
//
//
//        }
//        else {
//            usersService.checkBlockTime();
//            System.out.println("llll");
//           return "you are blocked";
//
//        }











//        smsService.send(SmsRequest.builder()
//                .username("9128214053")
//                .password("P@$$w0rd93")
//                .from("500010001422")
//                .to("09026473264")
//                .text(Integer.toString(otp))
//                .isFlash(false)
//                .build());


//    }





    @RequestMapping(value = "/enableUser",method = RequestMethod.POST)
    public Users makeUserEnable(@RequestBody Users users){



        //return this.usersService.makeUserEnable(users);
        return  user.makeUserEnable(users);
    }

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public Users getUser(){
        UserUtil userUtil = new UserUtil();

        System.out.println(userUtil.getCurrentuUser().getEmail());
       return userUtil.getCurrentuUser();
    }



}
