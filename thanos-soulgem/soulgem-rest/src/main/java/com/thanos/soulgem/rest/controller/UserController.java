package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.UserApp;
import com.thanos.soulgem.domain.identity.command.UserSignUp;
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


  @PostMapping
  public void save(@RequestBody UserSignUp userSignUp){
    userSignUp.validate();
    userApp.save(userSignUp);
  }


}
