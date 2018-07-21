package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@Document
public class Permission extends Entity {

  String url;

  String name;

  public Permission(String url, String name) {
    this.url = url;
    this.name = name;
  }

}
