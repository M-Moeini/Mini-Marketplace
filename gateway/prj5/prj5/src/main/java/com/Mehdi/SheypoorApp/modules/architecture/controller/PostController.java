package com.Mehdi.SheypoorApp.modules.architecture.controller;

import com.Mehdi.SheypoorApp.modules.architecture.Post;
import com.Mehdi.SheypoorApp.modules.architecture.UserUtil;
import com.Mehdi.SheypoorApp.modules.architecture.model.Posts;
import com.Mehdi.SheypoorApp.modules.architecture.service.PostService;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController  {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    private Post post;

    @Autowired
    private RestTemplate restTemplate;






    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional
    public  Posts registerPosts(@RequestPart("file") MultipartFile file,
                                @RequestParam(required = false) String  name,
                                @RequestParam(required = false) String price,
                                @RequestParam(required = false) String body,
                                @RequestParam(required = false) String cover) throws IOException {
        System.out.println(file);

       // restTemplate.postForEntity("http://localhost:8084/posts/register",file,null);


       // System.out.println(posts.getFile());

      // return postService.registerpost(posts);
        UserUtil userUtil = new UserUtil();
        String email= userUtil.getCurrentuUser().getEmail();

        return post.registerPosts(file,name,price,body,cover,email);

    }
    @RequestMapping(value = "/enablePost",method = RequestMethod.POST)
    public Posts makePostEnable( @RequestBody  Posts posts){


        //return postService.makePostEnable(posts);
        return post.makePostEnable(posts);
    }

    //for ADMIN
    @RequestMapping(value = "/allPosts",method = RequestMethod.GET)
    public Page<Posts> getAllPosts(@RequestParam(value = "page") String  page,
                                   @RequestParam(value = "size") String  size,
                                   @RequestParam(value="sort") String sort)
    {
        System.out.println("resid");



        //System.out.println("here1");

      //  return postService.findAllPosts(page,size,sort);
        return post.getAllPosts(page, size, sort);
    }

    //for USER
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public  List<Posts> getAllUsersPosts(){






        //return postService.findAllUsersPosts();
        return post.getAllUsersPosts();
    }

    //for USER
    @RequestMapping(value = "/myPosts",method = RequestMethod.POST)
    public List<Posts> getMyPosts(){
        UserUtil userUtil = new UserUtil();
         String email= userUtil.getCurrentuUser().getEmail();
        System.out.println("email"+email);




        //return postService.findMyPosts();
        return post.getMyPosts(email);
    }


//    @RequestMapping(value = "/rest", method = RequestMethod.GET)
//    public @ResponseBody List<Posts> getPosts() {
//        return postService.findAllPosts();
//    }

//    @RequestMapping(value = {"/rest", ""}, method = RequestMethod.POST)
//    public @ResponseBody Posts registerPost(@RequestBody Posts posts) throws IOException {
//        return postService.registerpost(posts);
//    }

}