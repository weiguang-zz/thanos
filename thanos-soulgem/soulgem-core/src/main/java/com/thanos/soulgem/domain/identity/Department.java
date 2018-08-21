package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
@CompoundIndexes({
    @CompoundIndex(name = "identity", def = "{'company.name' : 1, 'name': 1}")
})
public class Department extends Aggregate{

  @DBRef
  Company company;

  String name;

  //父级部门
  ObjectId parent;

  String telephone;

  //备注
  String mark;

  public Department(Company company, String name,
      ObjectId parent, String telephone, String mark) {
    this.company = company;
    this.name = name;
    this.parent = parent;
    this.telephone = telephone;
    this.mark = mark;
  }

}
