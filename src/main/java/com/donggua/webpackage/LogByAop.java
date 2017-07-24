package com.donggua.webpackage;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by HP on 2017/7/14.
 */
//@Configuration
//@EnableAspectJAutoProxy//表示启动自动代理功能，即AOP
//@ComponentScan
//public class LogByAop{
//    @Bean
//    public LogByAop1 log(){
//        System.out.println("LogByAop is created");
//        return new LogByAop1();
//    }
//
//
//}


@EnableAspectJAutoProxy//表示启动自动代理功能，即AOP
@Component
@Aspect
class LogByAop1 {

    @Pointcut("execution( * HelloWorld.getCountryByID(..))")
    public void getCountryByID(){}//无方法实现，主要用作标识切点的ID

    @Before("getCountryByID()")
    public void logBefore(){
        System.out.println("HelloWorld.getCountryByID() is called");
    }

    @AfterThrowing("getCountryByID()")//方法抛出异常后返回
    public void logWhenException(){
        System.out.println("log: catch a exception");
    }

    @After("getCountryByID()")//方法抛出异常后返回
    public void logAfterCalled(){
        System.out.println("log: after method return");
    }


    @Pointcut("execution( * Controller2.testAround(..))")
    public void testAroundID(){}

    @Around("testAroundID()")
    public void measureRunTime(ProceedingJoinPoint jp){
        try{
            long begin = System.nanoTime();
            jp.proceed();
            System.out.println("method run time :" + (System.nanoTime() - begin) / 1000000000L);
        }
        catch(Throwable ex){}
    }

}
