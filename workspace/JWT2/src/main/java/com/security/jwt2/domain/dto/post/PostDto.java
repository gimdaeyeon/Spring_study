package com.security.jwt2.domain.dto.post;

import com.security.jwt2.domain.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String loginId;
    private String nickname;

    public PostDto(String content, LocalDateTime createdDate, Long id, String loginId, LocalDateTime modifiedDate, String nickname, String title) {
        this.content = content;
        this.createdDate = createdDate;
        this.id = id;
        this.loginId = loginId;
        this.modifiedDate = modifiedDate;
        this.nickname = nickname;
        this.title = title;
    }

    public Post toEntity(){
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }


}
