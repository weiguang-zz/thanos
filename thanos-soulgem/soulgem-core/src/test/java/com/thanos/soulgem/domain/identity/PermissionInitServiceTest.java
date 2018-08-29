package com.thanos.soulgem.domain.identity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.thanos.soulgem.IntegrationTestConfiguration;
import com.thanos.soulgem.domain.identity.PermissionInitServiceTest.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 8/28/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {IntegrationTestConfiguration.class, TestConfiguration.class})
public class PermissionInitServiceTest{
  @Autowired
  PermissionRepo permissionRepo;

  @Test
  public void testSync(){

    Permission permission = permissionRepo.findByName("someName");
    assertNotNull(permission);
    assertEquals("someName",permission.name);
    assertEquals(PermissionGroup.Equipment.value(), permission.group);
    assert permission.className.contains("TestBean");
    assert permission.methodGenericString.contains("someMethod");
  }

  @Configuration
  static class TestConfiguration{
    @Bean
    public TestBean testBean(){
      return new TestBean();
    }
  }

  static class TestBean{
    @PermissionPoint(name = "someName", group = PermissionGroup.Equipment)
    public void someMethod(String someString){

    }

  }




}
