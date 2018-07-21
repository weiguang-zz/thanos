package com.thanos.soulgem.app;

import com.thanos.soulgem.IntegrationTestConfiguration;
import com.thanos.soulgem.domain.authority.User;
import com.thanos.soulgem.domain.authority.UserRepo;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IntegrationTestConfiguration.class)
public class UserAppTest {

  @Resource
  UserApp userApp;

  @Test
  public void save() {
    User user = new User("hhhah","ppppp");
    System.out.println("done");
  }

}
