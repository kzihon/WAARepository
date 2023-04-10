package miu.edu.WAA_labs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="Post_entity")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
   // @ManyToOne
//    @JoinTable(name = "Post_User",
//            joinColumns={@JoinColumn(name = "Post_id")},
//            inverseJoinColumns={@JoinColumn(name = "User_id")}
//    )
   // private User user;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "post_id")
//    private List<Comment> comments;

//    public void setComment(Comment comment){
//        comments.add(comment);
//    }


}
