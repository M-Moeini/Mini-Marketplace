package com.mehdi.other.architecture.service;

import com.mehdi.other.architecture.UserUtil;
import com.mehdi.other.architecture.model.Posts;
import com.mehdi.other.architecture.model.Users;
import com.mehdi.other.architecture.repository.PostRepository;
import com.mehdi.other.architecture.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private UsersRepository usersRepository;
    public UserUtil userUtil;

    @Autowired
    public void service(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Posts registerpost( Posts posts,String email) throws IOException {

        String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
        System.out.println("fileeee");
        System.out.println(posts.getName());
        System.out.println(posts.getFile());
        byte[] bytes = posts.getFile().getBytes();
        String name = UUID.randomUUID() + "." + Objects.requireNonNull(posts.getFile().getContentType()).split("/")[1];
        Files.write(Paths.get(path + File.separator + name), bytes);
        posts.setCover(name);


        Users users =usersRepository.findByemail(email);
        posts.setUsers(users);

       // posts.setUsers(getCurrentUser());


        return this.postRepository.save(posts);

    }
    public Users getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Users users =usersRepository.findByemail(email);
        return users;

    }

    public Page<Posts> findAllPosts(String  page, String  size, String sort) {

        System.out.println("inja");

        return this.postRepository.findAll(PageRequest.of(Integer.parseInt(page),
                Integer.parseInt(size),
                Sort.by(sort).descending()));

      //  return (Page<Posts>) this.postRepository.findAll();
    }


    public List<Posts> findAllUsersPosts(){
        List<Posts> myposts = postRepository.findAll();
        List<Posts> posts =  new ArrayList<Posts>();
        for (int i=0;i<myposts.size();i++){
            if(myposts.get(i).getUsers()!=null){
                System.out.println("i "+i);
                if (myposts.get(i).getStatus().equals("enable")) {
                    myposts.get(i).getUsers().setPassword(null);
                    myposts.get(i).getUsers().setPhoneNumber(null);
                    posts.add(myposts.get(i));
                    System.out.println(i);
                }

            }

        }


        System.out.println("here3");
        System.out.println(myposts);


        return posts;
    }

    public  List<Posts> findMyPosts(String email){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
        Users users =usersRepository.findByemail(email);

        System.out.println(email);

        Long id = users.getId();
        Posts posts1;
        List<Posts> posts = postRepository.findAll();

        List<Posts> myPosts =  new ArrayList<Posts>();

        System.out.println(posts.size());

        for(int i=0;i<posts.size();i++){

            Users users1 = posts.get(i).getUsers();
            if(users1!=null){
                if(users1.getId()==id){

                    myPosts.add(posts.get(i));

                }

            }
        }


        System.out.println("here4 is:"+myPosts);

        return myPosts;
    }

    @Transactional
    public Posts makePostEnable(Posts posts){
        String code = posts.getCode();
        String status = posts.getStatus();
        Posts posts1 =  postRepository.findByCode(code);
        posts1.setStatus(status);
        return posts1;







    }
}

