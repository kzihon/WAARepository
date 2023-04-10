package miu.edu.WAA_labs.aop;

import miu.edu.WAA_labs.entity.Logger;
import miu.edu.WAA_labs.entity.LoggerException;
import miu.edu.WAA_labs.entity.MyException;
import miu.edu.WAA_labs.repository.LoggerExceptionRepo;
import miu.edu.WAA_labs.repository.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAOP {
    @Autowired
    private LoggerRepo loggerRepo;

    @Autowired
    private LoggerExceptionRepo loggerExceptionRepo;
    @Pointcut("execution(* miu.edu.WAA_labs.controller.UserController.*(..))")
    public void transactionLog(){

    }

    @Pointcut("@annotation(miu.edu.WAA_labs.aop.ExecutionTime)")
    public void executionTimeAnnotation(){

    }

    @Around("executionTimeAnnotation()")
    public void executionTimeAnnotationAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish =  System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() +
                " takes ns: " + (finish-start));
    }


    @After("transactionLog()")
    public void transaction_log(JoinPoint joinPoint){
        loggerRepo.save(new Logger(LocalDate.now(), LocalTime.now(),
                joinPoint.getSignature().getName()));
    }
    @AfterThrowing(value = "transactionLog()", throwing = "exception")
    public void exception_transaction_log(JoinPoint joinPoint, MyException exception){
        loggerExceptionRepo.save(new LoggerException(LocalDate.now(), LocalTime.now(),
                joinPoint.getSignature().getName(), exception.getMessage()));
    }

}
