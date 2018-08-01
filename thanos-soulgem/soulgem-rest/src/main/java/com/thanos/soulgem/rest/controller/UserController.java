package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.UserApp;
import com.thanos.soulgem.domain.authority.Company;
import com.thanos.soulgem.domain.authority.CompanyRepo;
import com.thanos.soulgem.domain.authority.User;
import static com.thanos.soulgem.rest.check.InputAssert.*;

import com.thanos.soulgem.rest.command.UserSignUp;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/users")
public class UserController {
  @Resource
  UserApp userApp;

  @Resource
  CompanyRepo companyRepo;


  @PostMapping
  public void save(@RequestBody UserSignUp userSignUp){
    Company company = companyRepo.findByName(userSignUp.getCompanyName());
    notNull(company, "company not exists");
    User user = new User(company, userSignUp.getUsername(), userSignUp.getPassword());
    userApp.save(user);
  }


}
