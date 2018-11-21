package com.thanos.portal.domain.identity;

import com.thanos.common.domain.Aggregate;
import com.thanos.common.domain.exception.BizAssert;
import com.thanos.portal.domain.identity.command.UserUpdate;
import java.util.ArrayList;
import java.util.Date;
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
  @Indexed(unique = true)
  String realname;

  String password;

  String mobile;

  Boolean passwordChanged = false;

  String createdBy;

  Date createdAt;

  @DBRef
  List<Role> roles = new ArrayList<>();

  public User(Company company,String username,String realname,String mobile,String createdBy) {
    this.company = company;
    this.username = username;
    this.realname = realname;
    this.password = DEFAULT_PASSWORD;
    this.mobile = mobile;
    this.createdBy = createdBy;
    createdAt = new Date();
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
  public void assinAllRole(List<Role> roles){
    this.roles = roles;
  }

  public String password(){
    return password;
  }

  public static String defaultPassword(){
    return DEFAULT_PASSWORD;
  }

  public String username() {
    return username;
  }

  public String realname() {
    return realname;
  }

  public void merge(UserUpdate userUpdate) {
    this.realname = userUpdate.getRealname();
    this.mobile = userUpdate.getMobile();
  }
}
