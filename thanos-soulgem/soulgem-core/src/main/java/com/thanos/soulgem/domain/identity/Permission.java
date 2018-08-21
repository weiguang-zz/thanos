package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.Aggregate;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
public class Permission extends Aggregate{

  @Indexed(unique = true)
  String name;

  String url;


  public Permission(String url, String name) {
    this.url = url;
    this.name = name;
  }

}
