package miu.edu.WAA_labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LoggerException {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    //    @ManyToOne
//    private User user;
    private String opration;

    private String exceptionType;

    public LoggerException(LocalDate date, LocalTime time, String opration,String exceptionType) {
        this.date = date;
        this.time = time;
        // this.user = user;
       this.opration = opration;
        this.exceptionType =exceptionType;
    }
}
