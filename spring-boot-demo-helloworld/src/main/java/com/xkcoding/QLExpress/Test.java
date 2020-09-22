package com.xkcoding.QLExpress;


import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;
import org.junit.Assert;

/**
 * @Author : WuDazhong
 * @Date :2020/9/18 23:30
 * @Description : 測試
 */
public class Test {



  public static void main(String[] args) throws Exception {
    ExpressRunner runner = new ExpressRunner();
    DefaultContext<String, Object> context = new DefaultContext<>();
    context.put("a",1);
    context.put("b",2);
    context.put("c",3);
    String express = "a+b*c";
    // isTrace 这个主要是是否输出脚本的编译解析过程，一般对于业务系统来说关闭之后会提高性能。
    Object r = runner.execute(express, context, null, true, false);
    System.out.println(r);
    Assert.assertEquals(7, r);


  }

  /**
   * 测试新增
   * @throws Exception
   */
  @org.junit.Test
  public  void test1() throws Exception {
    //(1)addOperator
    ExpressRunner runner = new ExpressRunner();

    DefaultContext<String, Object> context = new DefaultContext<>();
    runner.addOperator("join",new JoinOperator());
    Object r = runner.execute("1 join 2 join 3", context, null, false, false);
    System.out.println(r);
  }

  /**
   *  测试宏
   * @throws Exception
   */
  @org.junit.Test
  public  void test2() throws Exception {
    //(1)addOperator
    ExpressRunner runner = new ExpressRunner();
    runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
    runner.addMacro("是否优秀", "计算平均成绩>90");
    IExpressContext<String, Object> context =new DefaultContext<>();
    context.put("语文", 88);
    context.put("数学", 99);
    context.put("英语", 95);
    Object result = runner.execute("是否优秀", context, null, false, false);
    System.out.println(result);


  }


}




