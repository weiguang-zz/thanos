package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
@Aggregate
@CompoundIndexes({
    @CompoundIndex(name = "identity", def = "{'company.name' : 1, 'name': 1}")
})
@Document
public class Department {

  @DBRef
  Company company;

  String name;

  //父级部门
  Department parent;

  String telephone;

  //备注
  String mark;

  public Department(Company company, String name,
      Department parent, String telephone, String mark) {
    this.company = company;
    this.name = name;
    this.parent = parent;
    this.telephone = telephone;
    this.mark = mark;
  }

}
