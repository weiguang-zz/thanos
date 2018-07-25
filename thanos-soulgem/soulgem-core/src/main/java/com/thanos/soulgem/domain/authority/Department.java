package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
@Aggregate
public class Department {
  @Id
  ObjectId id;

  String name;

  Department parent;//父级部门

  String telephone;

  //备注
  String mark;

}
