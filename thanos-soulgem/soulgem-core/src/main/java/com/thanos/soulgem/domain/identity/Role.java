package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.basic.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@CompoundIndexes({
    @CompoundIndex(name = "identity", def = "{'companyId' : 1, 'name': 1}")
})
public class Role extends Aggregate{

  ObjectId companyId;

  String name;

  String remark;

  String createdBy;

  Date createdAt;

  List<Permission> permissions = new ArrayList<>();
  List<Menu> menus = Collections.emptyList();

  public Role(ObjectId companyId, String name,String createdBy, String remark) {
    this.name = name;
    this.companyId = companyId;
    this.createdBy = createdBy;
    this.remark = remark;
    this.createdAt = new Date();
  }

  public void assinPermission(Permission permission){
    permissions.add(permission);
  }

  public void assginPermissions(List<Permission> permissions){
    this.permissions = permissions;
  }

  public void assginMenus(List<Menu> menus){
    this.menus = menus;
  }

  public void updateName(String name){
    this.name = name;
  }

  public void updateRemark(String remark){
    this.remark = remark;
  }

  public boolean hasPermission(String methodGenericString){
    for(Permission permission:permissions){
      if(permission.methodGenericString.equals(methodGenericString)){
        return true;
      }
    }
    return false;
  }

}
