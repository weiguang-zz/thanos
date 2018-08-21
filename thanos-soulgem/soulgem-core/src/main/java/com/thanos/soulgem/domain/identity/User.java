package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import com.thanos.common.domain.exception.BizAssert;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@CompoundIndexes({
    @CompoundIndex(name = "company_username", def = "{'company.id' : 1, 'username': 2}")
})
public class User extends Aggregate {

  @DBRef
  Company company;

  @DBRef
  Department department;

  String username;

  String password;

  @DBRef
  List<Role> roles = new ArrayList<>();

  public User(Company company,String username, String password) {
    this.company = company;
    this.username = username;
    this.password = password;
  }

  public boolean hasPermission(String url){
    for(Role role:roles){
      if(role.hasPermission(url)){
        return true;
      }
    }
    return false;
  }


  public void assginDepartment(Department department){
    BizAssert.check(department.company.name.equals(company.name),
        "用户所在公司跟部门所在的公司不一致");
    this.department = department;
  }

  public void assinRole(Role role){
    roles.add(role);
  }

}
