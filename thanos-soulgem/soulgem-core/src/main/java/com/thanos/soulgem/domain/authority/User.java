package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Document
public class User extends BaseEntity {

  @DBRef
  Company company;

  Department department;

  String username;

  String password;

  @DBRef
  List<Role> roles = new ArrayList<>();

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void assinRole(Role role){
    roles.add(role);
  }

}
