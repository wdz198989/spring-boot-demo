package com.xkcoding.swagger.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author : WuDazhong
 * @Date :2020/10/6 13:29
 * @Description : 强大的环绕通知
 * 环绕通知接受ProceedingJoinPoint作为参数，它来调用被通知的方法。通知方法中可以做任何的事情，
 * 当要将控制权交给被通知的方法时，需要调用ProceedingJoinPoint的proceed()方法。
 * 当你不调用proceed()方法时，将会阻塞被通知方法的访问。
 */
@Aspect
@Component
public class AroundAspect {

  /**
   * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
   *通过@Pointcut注解声明频繁使用的切点表达式
   */
  @Pointcut("execution(public * com.xkcoding.swagger.controller.AopController.Jokic())")
  public void BrokerAspect(){

  }


  /**
   * @description  使用环绕通知
   */
  @Around("BrokerAspect()")
  public void doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
    try{
      System.out.println("经纪人正在处理球星赛前事务！");
      pjp.proceed();
      System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
    }
    catch(Throwable e){
      System.out.println("异常通知：球迷要求退票！");
    }
  }
}
