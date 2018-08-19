package com.thanos.soulgem.domain.authority;

import static org.junit.Assert.*;

import com.thanos.soulgem.BaseIntegrationTest;
import com.thanos.soulgem.IntegrationTestConfiguration;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
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

  @Test
  public void validatePermission() {
    String someUrl = "/testUrl";
    String someCompanyName = "company";
    String someUsername = "someUsername";
    Permission somePermission = new Permission(someUrl, "test");
    permissionRepo.save(somePermission);
    Company someCompany = new Company(someCompanyName,null,null);
    companyRepo.save(someCompany);
    Role someRole = new Role(someCompany,"role");
    someRole.assinPermission(somePermission);
    roleRepo.save(someRole);
    User someUser = new User(someCompany ,
        someUsername,"somePassword");
    someUser.assinRole(someRole);
    userRepo.save(someUser);

    assertTrue(validationService.validatePermission(someCompany.id, someUsername,someUrl));
    String otherUrl = "/otherUrl";
    assertFalse(validationService.validatePermission(someCompany.id, someUsername,otherUrl));

  }

}
