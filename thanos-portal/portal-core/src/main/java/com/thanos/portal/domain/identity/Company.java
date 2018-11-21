package com.thanos.portal.domain.identity;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
public class Company extends Aggregate{

  @Indexed(unique = true)
  String name;

  ObjectId parent;

  String telephone;

  public Company(String name, ObjectId parent, String telephone) {
    this.name = name;
    this.parent = parent;
    this.telephone = telephone;
  }

}
