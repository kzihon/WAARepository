package miu.edu.WAA_labs.entity;

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
@Table(name ="User_entity")
public class User {
    @Id
    @GeneratedValue
    long id;
    String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "user_id")
    List<Post> posts;

}
