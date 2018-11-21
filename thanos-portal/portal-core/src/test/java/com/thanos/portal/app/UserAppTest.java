package com.thanos.portal.app;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.thanos.portal.BaseIntegrationTestConfiguration;
import com.thanos.portal.domain.identity.Company;
import com.thanos.portal.domain.identity.CompanyRepo;
import com.thanos.portal.domain.identity.PermissionInitService;
import com.thanos.portal.domain.identity.User;
import com.thanos.portal.domain.identity.UserRepo;
import javax.annotation.Resource;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseIntegrationTestConfiguration.class})
public class UserAppTest {

  @Resource
  CompanyRepo companyRepo;
  @Resource
  UserRepo userRepo;
  @Resource
  UserApp userApp;

  @Test(expected = Exception.class)
  public void testIdentity(){
    Company company = new Company("name",null,"132");
    companyRepo.save(company);
    company = new Company("name",null,"132");
    companyRepo.save(company);
    System.out.println("done");
  }
  @Test
  public void testQueryByKeyword(){
    User user1 = new User(null,"user1","realname1",null, null);
    User user2 = new User(null,"user2","realname2",null, null);
    userRepo.saveAll(ImmutableList.of(user1,user2));

    Pageable page = PageRequest.of(0,10);
    assertEquals(2, userApp.queryByUsernameOrRealname("user",page).getContent().size());
    assertEquals(2, userApp.queryByUsernameOrRealname("realname",page).getContent().size());
    assertEquals(1, userApp.queryByUsernameOrRealname("user1",page).getContent().size());
    assertEquals(1, userApp.queryByUsernameOrRealname("realname2",page).getContent().size());
    assertEquals(0, userApp.queryByUsernameOrRealname("somename",page).getContent().size());

    userRepo.deleteAll();
  }

  @AfterClass
  public static void cleanPermissions(){
    PermissionInitService.clearPermissions();
  }

}
