package com.xkcoding.swagger.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author : WuDazhong
 * @Date :2020/10/6 13:34
 * @Description :当通知方法需要传入参数我们又该怎样处理呢？
 * 和之前创建的切面一样，这里的不同点在于切点还声明了要提供给通知方法的参数。
 * 切点表达式args(point)表明传递给GameDataAspect()方法中的int类型参数也会传递到通知中去，参数名point和缺点方法签名中的参数相匹配
 */
@Aspect
@Component
public class GameDataAspect {
  /**
   * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
   *通过@Pointcut注解声明频繁使用的切点表达式
   */
  @Pointcut("execution(public * com.xkcoding.swagger.controller.AopController.Durant(int)) && args(point))")
  public void GameDataAspect(int point){

  }

  /**
   * @description  使用环绕通知
   */
  @Around("GameDataAspect(point)")
  public void doAroundGameData(ProceedingJoinPoint pjp, int point) throws Throwable {
    try{
      System.out.println("球星上场前热身！");
      pjp.proceed();
      System.out.println("球星本场得到" + point + "分" );
    }
    catch(Throwable e){
      System.out.println("异常通知：球迷要求退票！");
    }
  }
}
