package com.Mehdi.SheypoorApp.modules.architecture.controller;

import com.Mehdi.SheypoorApp.modules.architecture.model.Posts;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
import com.Mehdi.SheypoorApp.modules.architecture.service.PostService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private PostService postService;

    @Autowired
    public MainController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = {"/index","/"})
    public String  welcome(){


        return  "Welcome";


    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login() {

        return "login";

    }
    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public String access(){
        return "access denied";
    }


}
