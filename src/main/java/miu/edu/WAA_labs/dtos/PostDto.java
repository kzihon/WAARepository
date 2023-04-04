package miu.edu.WAA_labs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
}
