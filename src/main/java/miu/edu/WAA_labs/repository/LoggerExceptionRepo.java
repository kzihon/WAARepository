package miu.edu.WAA_labs.repository;

import miu.edu.WAA_labs.entity.LoggerException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerExceptionRepo  extends JpaRepository<LoggerException, Long> {
}
