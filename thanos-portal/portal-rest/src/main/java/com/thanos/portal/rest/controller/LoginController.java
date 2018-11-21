package com.thanos.portal.rest.controller;

import static com.thanos.portal.rest.check.InputAssert.notBlank;

import com.thanos.portal.app.UserApp;
import com.thanos.portal.domain.identity.User;
import com.thanos.portal.rest.filter.UserAccessFilter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
@RestController
public class LoginController {

  @Autowired
  UserApp userApp;

  @PostMapping("/login")
  public User login(@RequestBody Map<String,String> data, HttpServletRequest request){
    String username = data.get("username");
    String password = data.get("password");
    notBlank(username,"username");
    notBlank(password, "password");
    User user = userApp.login(username, password);
    request.getSession().setAttribute(UserAccessFilter.LOGINED_USER, user);
    return user;
  }

}
