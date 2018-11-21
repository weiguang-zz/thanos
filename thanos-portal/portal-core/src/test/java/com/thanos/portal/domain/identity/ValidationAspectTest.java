package com.thanos.portal.domain.identity;

import com.thanos.common.domain.exception.AuthorizationException;
import com.thanos.portal.BaseIntegrationTestConfiguration;
import com.thanos.portal.domain.identity.PermissionPointConfiguration.TestBean;
import com.thanos.portal.domain.identity.ValidationAspectTest.MockDefaultUserConfiguration;
import javax.annotation.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseIntegrationTestConfiguration.class, PermissionPointConfiguration.class,
    MockDefaultUserConfiguration.class})
@ActiveProfiles("auth")
public class ValidationAspectTest{


  @Resource
  UserRepo userRepo;
  @Resource
  CompanyRepo companyRepo;
  @Resource
  PermissionRepo permissionRepo;
  @Resource
  RoleRepo roleRepo;

  @Resource
  TestBean testBean;

  static String someUsername = "someUsername";
  private String somePermissionName = "somePermissionName";

  @Before
  public void initializeUser(){
    Company someCompany = new Company("someCompany",null,null);
    companyRepo.save(someCompany);
    User user = new User(someCompany,someUsername,"someRealName",null, null);
    userRepo.save(user);
  }

  @After
  public void clean(){
    companyRepo.deleteAll();
    userRepo.deleteAll();
    roleRepo.deleteAll();
  }

  @Test(expected = AuthorizationException.class)
  public void testNoPermission(){
    testBean.someMethod("someString");
  }

  @Test
  public void testHasPermission(){
    User user = userRepo.findByUsername(someUsername);
    Permission permission = permissionRepo.findByName(somePermissionName);
    Role role = new Role(user.company.id(), "somerole", null,null);
    role.assinPermission(permission);
    roleRepo.save(role);
    user.assinRole(role);
    userRepo.save(user);

    testBean.someMethod("someString");

  }

  @AfterClass
  public static void cleanPermissions(){
    PermissionInitService.clearPermissions();
  }



  @Configuration
  static class  MockDefaultUserConfiguration{
    @Bean
    public DefaultUserHolder defaultUserHolder(){
      return new DefaultUserHolder();
    }
  }

  static class DefaultUserHolder implements UserHolder{
    @Autowired
    UserRepo userRepo;

    @Override
    public User getUser() {
      return userRepo.findByUsername(someUsername);
    }
  }



}
