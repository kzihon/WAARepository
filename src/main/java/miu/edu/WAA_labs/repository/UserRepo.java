package miu.edu.WAA_labs.repository;

import miu.edu.WAA_labs.entity.Post;
import miu.edu.WAA_labs.entity.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select user FROM User user WHERE count(user.posts) >1")
    public List<User> userWithMoreThankOnePost();

//    List<User> findAll();
//    User findById(Long id);
//    void save(User user);
//    void update(long id, User user);
//    void delete(long id);

}
