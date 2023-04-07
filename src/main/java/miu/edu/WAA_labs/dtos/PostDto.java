package miu.edu.WAA_labs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.WAA_labs.entity.Comment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}
