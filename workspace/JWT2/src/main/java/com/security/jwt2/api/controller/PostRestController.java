package com.security.jwt2.api.controller;

import com.security.jwt2.domain.dto.post.PostDto;
import com.security.jwt2.exception.AlreadyExistsException;
import com.security.jwt2.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostRestController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(){
        try {
            return ResponseEntity.ok(postService.getPostAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        try {
            return ResponseEntity.ok(postService.register(postDto));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostOne(@PathVariable("postId")Long postId){
        return ResponseEntity.ok(postService.getPostOne(postId));
    }

    @PutMapping("/{postId}")
    public void modifyPostOne(@PathVariable("postId")Long postId,
                              @RequestBody PostDto postDto){
            postDto.setId(postId);
            postService.modifyPost(postDto);
    }

    @DeleteMapping("/{postId}")
    public void removePostOne(@PathVariable("postId")Long postId){
        postService.removePost(postId);
    }

}
