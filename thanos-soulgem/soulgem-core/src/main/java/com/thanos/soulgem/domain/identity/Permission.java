package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.ValueObject;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class Permission{

  String name;

  String group;

  String methodGenericString;//方法的签名

  public String group() {
     return group;
  }

  public Permission(String name, String group, String methodGenericString) {
    this.name = name;
    this.group = group;
    this.methodGenericString = methodGenericString;
  }

}
