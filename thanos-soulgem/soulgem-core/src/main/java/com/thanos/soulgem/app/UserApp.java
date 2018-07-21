package com.thanos.soulgem.app;

import com.thanos.soulgem.domain.authority.User;
import com.thanos.soulgem.domain.authority.UserRepo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class UserApp {
  @Resource
  UserRepo userRepo;

  public void save(User user){
    userRepo.save(user);
  }

}
