package com.Mehdi.SheypoorApp.modules.architecture;

import com.Mehdi.SheypoorApp.modules.architecture.model.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(url = "http://localhost:8084/posts" ,name = "posts")
public interface Post {


    @PostMapping(path = "register",consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public Posts registerPosts(@RequestPart("file") MultipartFile file,
                               @RequestParam(required = false) String  name,
                               @RequestParam(required = false) String price,
                               @RequestParam(required = false) String body,
                               @RequestParam(required = false) String cover,
                               @RequestParam String email);

    @PostMapping("/enablePost")
    public Posts makePostEnable( @RequestBody Posts posts);

    @GetMapping("/allPosts")
    public Page<Posts> getAllPosts(@RequestParam(value = "page") String  page,
                                   @RequestParam(value = "size") String  size,
                                   @RequestParam(value="sort") String sort);

    @GetMapping("/all")
    public List<Posts> getAllUsersPosts();

    @PostMapping ("/myPosts")
    public List<Posts> getMyPosts(@RequestBody String email);
}
