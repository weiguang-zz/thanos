package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@Document
public class Role extends BaseEntity {

  String name;

  @DBRef
  List<Permission> permissions = new ArrayList<>();

  public Role(String name) {
    this.name = name;
  }

  public void assinPermission(Permission permission){
    permissions.add(permission);
  }

}
