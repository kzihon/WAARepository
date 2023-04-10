package miu.edu.WAA_labs.entity;

import jakarta.persistence.*;
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
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
//    @ManyToOne
//    private User user;
    private String Opration;

    public Logger(LocalDate date, LocalTime time, String opration) {
        this.date = date;
        this.time = time;
       // this.user = user;
        Opration = opration;
    }
}
