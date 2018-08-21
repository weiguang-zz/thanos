package com.thanos.common.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 * the class annotated by this is a aggregate root
 */
@Document
public abstract class Aggregate {
  @Id
  public ObjectId id;

}
