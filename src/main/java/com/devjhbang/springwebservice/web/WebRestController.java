package com.devjhbang.springwebservice.web;

import com.devjhbang.springwebservice.domain.posts.PostsRepository;
import com.devjhbang.springwebservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private Environment env;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld3333";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }

    @GetMapping("/profile")
    public String getProfile() {

        System.out.println("##########"+"local");

        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
