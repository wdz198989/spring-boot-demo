package com.xkcoding.QLExpress;


import com.ql.util.express.Operator;

/**
 * @Author : WuDazhong
 * @Date :2020/9/21 11:07
 * @Description :
 */
public class JoinOperator extends Operator {
  public Object executeInner(Object[] list) throws Exception {
    Object opdata1 = list[0];
    Object opdata2 = list[1];
    if(opdata1 instanceof java.util.List){
      ((java.util.List)opdata1).add(opdata2);
      return opdata1;
    }else{
      java.util.List result = new java.util.ArrayList();
      result.add(opdata1);
      result.add(opdata2);
      return result;
    }
  }
}
