package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@Document
public class Permission{
  @Id
  String name;

  String url;


  public Permission(String url, String name) {
    this.url = url;
    this.name = name;
  }

}
