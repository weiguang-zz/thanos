package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Entity;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
public class User extends Entity{

  String username;
  String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

}
