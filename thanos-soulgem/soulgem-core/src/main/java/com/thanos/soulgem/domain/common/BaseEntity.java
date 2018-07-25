package com.thanos.soulgem.domain.common;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
public class BaseEntity {
  @Id
  ObjectId id;

  Date createdAt;

  Date updatedAt;

  String createdBy;

  public String createdBy() {
    return createdBy;
  }

}
