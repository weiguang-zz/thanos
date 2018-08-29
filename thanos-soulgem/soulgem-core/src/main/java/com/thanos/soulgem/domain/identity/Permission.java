package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.ValueObject;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class Permission{

  @Indexed(unique = true)
  String name;

  String group;
  String className;
  String methodGenericString;//方法的签名


  public Permission(String name, String group, String className, String methodGenericString) {
    this.name = name;
    this.group = group;
    this.className = className;
    this.methodGenericString = methodGenericString;
  }

}
