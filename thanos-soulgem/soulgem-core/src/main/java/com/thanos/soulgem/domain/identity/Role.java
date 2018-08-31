package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import java.util.ArrayList;
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

  List<Permission> permissions = new ArrayList<>();

  public Role(ObjectId companyId, String name) {
    this.name = name;
    this.companyId = companyId;
  }

  public void assinPermission(Permission permission){
    permissions.add(permission);
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
