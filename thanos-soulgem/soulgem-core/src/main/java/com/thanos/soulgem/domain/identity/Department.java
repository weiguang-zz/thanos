package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.identity.command.DepartmentUpdate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
@CompoundIndexes({
    @CompoundIndex(name = "identity", def = "{'companyId' : 1, 'name': 1}")
})
public class Department extends Aggregate{

  ObjectId companyId;

  String name;

  //父级部门
  Department parent;

  String telephone;

  //备注
  String remark;

  public Department(ObjectId companyId, String name, String telephone, String remark) {
    this.companyId = companyId;
    this.name = name;
    this.telephone = telephone;
    this.remark = remark;
  }

  public void merge(DepartmentUpdate update){
    this.name = update.getName();
    this.telephone = update.getTelephone();
    this.remark = update.getRemark();
  }

  public void setParent(Department parent) {
    this.parent = parent;
  }
}
