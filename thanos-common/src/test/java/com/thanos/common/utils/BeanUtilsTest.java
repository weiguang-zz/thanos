package com.thanos.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Create by zhangzheng on 9/9/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(JUnit4.class)
public class BeanUtilsTest {

  @Test
  public void testPropertySet(){
    A someA = new A("a",new Date(),1 );
    ADto aDto = BeanUtils.transfer(someA, ADto.class);
    assertEquals("a", aDto.a);
    assertNotNull(aDto.b);
    assertEquals(1, aDto.c);
  }


  static class A{
    String a;
    Date b;
    int c;

    public A(String a, Date b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }


  static class ADto{
    String a;
    Date b;
    int c;
  }

}
