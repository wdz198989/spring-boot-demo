package com.xkcoding.swagger.config;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Author : WuDazhong
 * @Date :2020/10/6 13:23
 * @Description :经纪人切面
 */


@Aspect
@Component
public class BrokenAspect {

  /**
   * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
   *通过@Pointcut注解声明频繁使用的切点表达式
   */
  @Pointcut("execution(public * com.xkcoding.swagger.controller.AopController.*(..)))")
  public void BrokerAspect(){

  }

  /**
   * @description  在连接点执行之前执行的通知
   */
  @Before("BrokerAspect()")
  public void doBeforeGame(){
    System.out.println("经纪人正在处理球星赛前事务！");
  }

  /**
   * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
   */
  @After("BrokerAspect()")
  public void doAfterGame(){
    System.out.println("经纪人为球星表现疯狂鼓掌！");
  }

  /**
   * @description  在连接点执行之后执行的通知（返回通知）
   */
  @AfterReturning("BrokerAspect()")
  public void doAfterReturningGame(){
    System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
  }

  /**
   * @description  在连接点执行之后执行的通知（异常通知）
   */
  @AfterThrowing("BrokerAspect()")
  public void doAfterThrowingGame(){
    System.out.println("异常通知：球迷要求退票！");
  }


}
