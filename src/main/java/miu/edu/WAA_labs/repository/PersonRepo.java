package miu.edu.WAA_labs.repository;

import miu.edu.WAA_labs.entity.Address;
import miu.edu.WAA_labs.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    //List<Person> PersonWAddress
}
