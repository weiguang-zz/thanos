package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Aggregate;
import com.thanos.soulgem.domain.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@Aggregate
@CompoundIndexes({
    @CompoundIndex(name = "identity", def = "{'company.name' : 1, 'name': 1}")
})
@Document
public class Role{

  @DBRef
  Company company;

  @Id
  String name;

  @DBRef
  List<Permission> permissions = new ArrayList<>();

  public Role(Company company, String name) {
    this.name = name;
    this.company = company;
  }

  public void assinPermission(Permission permission){
    permissions.add(permission);
  }

  public boolean hasPermission(String url){
    for(Permission permission:permissions){
      if(permission.url.equals(url)){
        return true;
      }
    }
    return false;
  }

}
