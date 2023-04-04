package miu.edu.WAA_labs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;

}
