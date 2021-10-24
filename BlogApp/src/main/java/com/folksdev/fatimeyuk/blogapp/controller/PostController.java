package com.folksdev.fatimeyuk.blogapp.controller;

import com.folksdev.fatimeyuk.blogapp.dto.CreatePostDto;
import com.folksdev.fatimeyuk.blogapp.dto.CreatePostRequest;
import com.folksdev.fatimeyuk.blogapp.enums.BlogStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/post")
public class PostController {

    List<CreatePostRequest> posts = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<CreatePostRequest>> getPosts() {

        posts.add(new CreatePostRequest(4, "Interface Segregation", "Lorem ipsum dolor sit amet.", BlogStatus.PUBLISHED));
        posts.add(new CreatePostRequest(2, "Dependency Injection", "Lorem ipsum dolor sit amet.", BlogStatus.DRAFT));
        posts.add(new CreatePostRequest(5, "Abstraction Class", "Lorem ipsum dolor sit amet.", BlogStatus.DELETED));

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreatePostDto> getPostById(@PathVariable Integer id) {

        CreatePostDto postDto = new CreatePostDto("Abstraction Class", "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet.", BlogStatus.DELETED);

        return ResponseEntity.ok(postDto);
    }

    @PostMapping
    public ResponseEntity<CreatePostDto> createPost(@Valid @RequestBody CreatePostRequest createPostRequest) {

        CreatePostDto postDto = new CreatePostDto(createPostRequest.getTitle(), createPostRequest.getContent(), createPostRequest.getStatus());

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable int id, @RequestBody String title) {

        return ResponseEntity.ok("id: " + id + " is updated with " + title);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedPost(@PathVariable int id) {

        return ResponseEntity.ok("The post is deleted with id:" + id);
    }
}
