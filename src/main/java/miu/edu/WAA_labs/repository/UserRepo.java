package miu.edu.WAA_labs.repository;

import miu.edu.WAA_labs.entity.Comment;
import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //List<User> findUsersWithMoreThanNPosts(int n);

    @Query("select u from User u Join fetch u.posts p where p.title= :title")
    List<User> findUsersByPostTitle(@Param("title") String title);

    @Query("SELECT u FROM User u JOIN FETCH u.posts p GROUP BY u HAVING COUNT(p) > :n")
    List<User> findUsersWithMoreThanNPostsQuery(@Param("n") int n);

    @Query("select user FROM User user WHERE count(user.posts) >1")
    public List<User> userWithMoreThankOnePost();

    @Query("select c from User u join fetch Post p join fetch Comment c where u.id =:user_id and p.id =:post_id and c.id =:comment_id")
    public Comment getUserForAParticularPostAndParticularCommnent(@Param("user_id") long user_id,@Param("post_id") long post_id,@Param("comment_id") long comment_id);
}
