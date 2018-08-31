package com.thanos.soulgem.app;

import com.thanos.soulgem.BaseIntegrationTestConfiguration;
import com.thanos.soulgem.domain.identity.Company;
import com.thanos.soulgem.domain.identity.CompanyRepo;
import com.thanos.soulgem.domain.identity.PermissionInitService;
import javax.annotation.Resource;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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

  @Test(expected = Exception.class)
  public void testIdentity(){
    Company company = new Company("name",null,"132");
    companyRepo.save(company);
    company = new Company("name",null,"132");
    companyRepo.save(company);
    System.out.println("done");
  }

  @AfterClass
  public static void cleanPermissions(){
    PermissionInitService.clearPermissions();
  }

}
