package com.thanos.soulgem.app;

import com.thanos.soulgem.BaseIntegrationTest;
import com.thanos.soulgem.domain.identity.Company;
import com.thanos.soulgem.domain.identity.CompanyRepo;
import com.thanos.soulgem.domain.identity.PermissionRepo;
import com.thanos.soulgem.domain.identity.RoleRepo;
import com.thanos.soulgem.domain.identity.UserRepo;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
public class UserAppTest extends BaseIntegrationTest {

  @Resource
  UserApp userApp;

  @Resource
  PermissionRepo permissionRepo;

  @Resource
  RoleRepo roleRepo;

  @Resource
  UserRepo userRepo;

  @Resource
  CompanyRepo companyRepo;

  @Test
  public void save() {
//    Permission permission = new Permission("/test/t1","somePermission");
//    permissionRepo.save(permission);
//
//    Role role = new Role("someRole");
//    role.assinPermission(permission);
//    roleRepo.save(role);
//
//    User user = new User("hhhah","ppppp");
//    user.assinRole(role);
//    userApp.save(user);
//
//
//    User user = userRepo.findOne(new ObjectId("5b52d93eaa73821d960a9116"));
//    System.out.println("done");
  }
  @Test(expected = Exception.class)
  public void testIdentity(){
    Company company = new Company("name",null,"132");
    companyRepo.save(company);
    company = new Company("name",null,"132");
    companyRepo.save(company);
    System.out.println("done");
  }

}
