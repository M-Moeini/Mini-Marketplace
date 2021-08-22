package com.mehdi.other.architecture.repository;

import com.mehdi.other.architecture.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts,Long> {


    Posts findByBody(String body);

    Posts findByCode(String code);

    ;
}
