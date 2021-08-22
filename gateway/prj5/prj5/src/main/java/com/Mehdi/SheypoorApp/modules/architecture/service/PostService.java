package com.Mehdi.SheypoorApp.modules.architecture.service;

import com.Mehdi.SheypoorApp.modules.architecture.model.Posts;
import com.Mehdi.SheypoorApp.modules.architecture.model.Users;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.PostRepository;
//import com.Mehdi.SheypoorApp.modules.architecture.repository.UsersRepository;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class PostService {
//
//   // private final PostRepository postRepository;
//    private UsersRepository usersRepository;
//
//    @Autowired
//    public void service(UsersRepository usersRepository){
//        this.usersRepository = usersRepository;
//    }
//
//    @Autowired
//    public PostService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    @Transactional
//    public Posts registerpost(Posts posts) throws IOException {
//
//        String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
//        byte[] bytes = posts.getFile().getBytes();
//        String name = UUID.randomUUID() + "." + Objects.requireNonNull(posts.getFile().getContentType()).split("/")[1];
//        Files.write(Paths.get(path + File.separator + name), bytes);
//        posts.setCover(name);
//
//
//
//        posts.setUsers(getCurrentUser());
//
//
//        return this.postRepository.save(posts);
//
//    }
//    public Users getCurrentUser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Users users =usersRepository.findByemail(email);
//        return users;
//
//    }
//
//    public Page<Posts> findAllPosts(String  page,String  size,String sort) {
//
//
//        return this.postRepository.findAll(PageRequest.of(Integer.parseInt(page),
//                                                        Integer.parseInt(size),
//                                                         Sort.by(sort).descending()));
//
//    }
//
//    public List<Posts> findAllUsersPosts(){
//        List<Posts> myposts = postRepository.findAll();
//        for (int i=0;i<myposts.size();i++){
//            if(myposts.get(i).getUsers()!=null){
//                myposts.get(i).getUsers().setPassword(null);
//                myposts.get(i).getUsers().setPhoneNumber(null);
//
//            }
//
//        }
//
//
//            return myposts;
//    }
//
//    public  List<Posts> findMyPosts(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Users users =usersRepository.findByemail(email);
//
//        Long id = users.getId();
//        Posts posts1;
//        List<Posts> posts = postRepository.findAll();
//
//        List<Posts> myPosts =  new ArrayList<Posts>();
//
//        System.out.println(posts.size());
//
//        for(int i=0;i<posts.size();i++){
//
//            Users users1 = posts.get(i).getUsers();
//            if(users1!=null){
//                if(users1.getId()==id){
//
//                    myPosts.add(posts.get(i));
//
//                }
//
//                }
//            }
//
//
//        return myPosts;
//    }
//
//    @Transactional
//    public Posts makePostEnable(Posts posts){
//        String code = posts.getCode();
//        String status = posts.getStatus();
//        Posts posts1 =  postRepository.findByCode(code);
//        posts1.setStatus(status);
//        return posts1;
//
//
//
//
//


 //   }
}
