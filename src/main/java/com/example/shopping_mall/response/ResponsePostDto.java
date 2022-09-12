package com.example.shopping_mall.response;


import com.example.shopping_mall.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePostDto {
    private Long  id;
    private String imgUrl;
    private String title;
    private int  cost;
    public Page<ResponsePostDto> toDtoList(Page<Post> postList){
        Page<ResponsePostDto> ResponsePostList = postList.map(m -> ResponsePostDto.builder()
                .id(m.getId())
                .imgUrl(m.getImgUrl())
                .title(m.getTitle())
                .cost(m.getCost())
                .build()
        );
        return ResponsePostList;
    }
}





