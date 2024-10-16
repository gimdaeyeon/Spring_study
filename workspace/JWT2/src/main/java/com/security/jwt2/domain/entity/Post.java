package com.security.jwt2.domain.entity;

import com.security.jwt2.domain.base.Period;
import com.security.jwt2.domain.dto.post.PostDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vue_post")
@Getter @Setter @ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private User user;

    @Builder
    public Post(String content, Long id, String title, User user) {
        this.content = content;
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public PostDto toDto(){
        PostDto dto = new PostDto();
        dto.setId(id);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setCreatedDate(getCreatedDate());
        dto.setModifiedDate(getModifiedDate());
        dto.setLoginId(user.getLoginId());
        dto.setNickname(user.getNickname());
        return dto;
    }



}
