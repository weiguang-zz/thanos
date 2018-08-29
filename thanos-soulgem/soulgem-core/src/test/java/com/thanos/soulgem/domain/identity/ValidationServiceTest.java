package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.exception.BusinessException;
import com.thanos.soulgem.BaseIntegrationTest;
import com.thanos.soulgem.IntegrationTestConfiguration;
import com.thanos.soulgem.domain.identity.PermissionInitServiceTest.TestBean;
import com.thanos.soulgem.domain.identity.PermissionInitServiceTest.TestConfiguration;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {IntegrationTestConfiguration.class, TestConfiguration.class})
public class ValidationServiceTest extends BaseIntegrationTest{

  @Resource
  ValidationService validationService;

  @Resource
  UserRepo userRepo;
  @Resource
  RoleRepo roleRepo;
  @Resource
  PermissionRepo permissionRepo;
  @Resource
  CompanyRepo companyRepo;

  @Resource
  TestBean testBean;

  @Test(expected = BusinessException.class)
  public void testNoPermission(){
    testBean.someMethod("someString");
  }







//  @Test
//  public void validatePermission() {
//    String someUrl = "/testUrl";
//    String someCompanyName = "company";
//    String someUsername = "someUsername";
//    Permission somePermission = new Permission(someUrl, "test");
//    permissionRepo.save(somePermission);
//    Company someCompany = new Company(someCompanyName,null,null);
//    companyRepo.save(someCompany);
//    Role someRole = new Role(someCompany.id(),"role");
//    someRole.assinPermission(somePermission);
//    roleRepo.save(someRole);
//    User someUser = new User(someCompany ,
//        someUsername,someUsername);
//    someUser.assinRole(someRole);
//    userRepo.save(someUser);
//
//    assertTrue(validationService.validatePermission(someUsername,someUrl));
//    String otherUrl = "/otherUrl";
//    assertFalse(validationService.validatePermission(someUsername,otherUrl));
//
//  }



}
