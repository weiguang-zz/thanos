package com.thanos.soulgem.domain.identity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.thanos.soulgem.BaseIntegrationTestConfiguration;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 8/28/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseIntegrationTestConfiguration.class, PermissionPointConfiguration.class})
public class PermissionInitServiceTest{
  @Autowired
  PermissionRepo permissionRepo;

  private String somePermissionName = "somePermissionName";

  @Test
  public void testSync(){
    Permission permission = permissionRepo.findByName(somePermissionName);
    assertNotNull(permission);
    assertEquals("somePermissionName",permission.name);
    assertEquals(PermissionGroup.Equipment.value(), permission.group);
    assert permission.methodGenericString.contains("someMethod");
  }

  @AfterClass
  public static void cleanPermissions(){
    PermissionInitService.clearPermissions();
  }




}
