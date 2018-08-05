package com.thanos.soulgem.app;

import com.thanos.soulgem.domain.authority.Company;
import com.thanos.soulgem.domain.authority.CompanyRepo;
import com.thanos.soulgem.domain.authority.User;
import com.thanos.soulgem.domain.authority.UserRepo;
import com.thanos.soulgem.domain.authority.command.UserSignUp;
import com.thanos.soulgem.domain.exception.BizAssert;
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

  @Resource
  CompanyRepo companyRepo;

  public void save(UserSignUp userSignUp){
    Company company = companyRepo.findByName(userSignUp.getCompanyName());
    BizAssert.check(company!=null, "company不存在");
    checkUserNameNotExist(userSignUp.getCompanyName(), userSignUp.getUsername());
    User user = new User(company, userSignUp.getUsername(), userSignUp.getPassword());
    userRepo.save(user);
  }


  private void checkUserNameNotExist(String companyName, String username){
    User user = userRepo.findByUsernameAndCompany_Name(username, companyName);
    BizAssert.check(user==null, "username:{} exists", username);
  }

}
