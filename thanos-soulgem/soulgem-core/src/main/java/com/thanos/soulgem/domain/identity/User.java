package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import com.thanos.common.domain.exception.BizAssert;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
public class User extends Aggregate {

  private static final String DEFAULT_PASSWORD = "888888";

  @DBRef
  Company company;

  @DBRef
  Department department;

  @Indexed(unique = true)
  String username;

  String realname;

  String password;

  Boolean passwordChanged = false;

  @DBRef
  List<Role> roles = new ArrayList<>();

  public User(Company company,String username,String realname) {
    this.company = company;
    this.username = username;
    this.realname = realname;
    this.password = DEFAULT_PASSWORD;
  }

  public void changePassword(String newPassword){
    this.password = newPassword;
    passwordChanged = true;
  }

  public boolean hasPermission(String methodGenericString){
    for(Role role:roles){
      if(role.hasPermission(methodGenericString)){
        return true;
      }
    }
    return false;
  }


  public void assginDepartment(Department department){
    BizAssert.check(department.companyId.equals(company.id()),
        "用户所在公司跟部门所在的公司不一致");
    this.department = department;
  }

  public void assinRole(Role role){
    roles.add(role);
  }

}
