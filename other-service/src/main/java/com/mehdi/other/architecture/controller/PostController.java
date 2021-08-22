package com.mehdi.other.architecture.controller;

import com.mehdi.other.architecture.GetCurrentUser;
import com.mehdi.other.architecture.UserUtil;
import com.mehdi.other.architecture.model.Posts;
import com.mehdi.other.architecture.model.Users;
import com.mehdi.other.architecture.repository.UsersRepository;
import com.mehdi.other.architecture.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;
    @Autowired
    private UsersRepository usersRepository;

    public UserUtil userUtil = new UserUtil(usersRepository);

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    private GetCurrentUser getCurrentUser;




    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional
    public Posts registerPosts(@RequestPart("file") MultipartFile file,
                               @RequestParam(required = false) String  name,
                               @RequestParam(required = false) String price,
                               @RequestParam(required = false) String body,
                               @RequestParam(required = false) String cover,
                               @RequestParam String email) throws IOException {
        System.out.println("cont"+file);
        //return null;
        Posts posts=new Posts();
        posts.setFile(file);
        posts.setName(name);
        posts.setPrice(price);
        posts.setBody(body);
        posts.setCover(cover);

        return postService.registerpost(posts,email);

    }
    @RequestMapping(value = "/enablePost",method = RequestMethod.POST)
    public Posts makePostEnable( @RequestBody Posts posts){

        return postService.makePostEnable(posts);
    }

    //for ADMIN
    @RequestMapping(value = "/allPosts",method = RequestMethod.GET)
    public Page<Posts> getAllPosts(@RequestParam(value = "page") String  page,
                                   @RequestParam(value = "size") String  size,
                                   @RequestParam(value="sort") String sort)
    {

        System.out.println("resid");
        System.out.println(page);
        System.out.println(size);
        System.out.println(sort);
        return postService.findAllPosts(page,size,sort);
    }

    //for USER
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Posts> getAllUsersPosts(){
       // System.out.println(getCurrentUser.getUser().getEmail());

       // System.out.println("email  :"+email);

       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // System.out.println(authentication);
       // String email = authentication.getName();
       // System.out.println(email);
      //  Users users =userUtil.getCurrentuUser();


//        System.out.println(SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal());

      //  System.out.println(users.getEmail());

        System.out.println("hello");

        System.out.println("bye");
        return postService.findAllUsersPosts();

    }

    //for USER
    @RequestMapping(value = "/myPosts",method = RequestMethod.POST)
    public List<Posts> getMyPosts(@RequestBody String email){
        System.out.println("email is :"+ email);

        return postService.findMyPosts(email);

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