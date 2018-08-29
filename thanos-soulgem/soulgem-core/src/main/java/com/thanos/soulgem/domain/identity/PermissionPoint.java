package com.thanos.soulgem.domain.identity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by zhangzheng on 8/26/18
 * Email:zhangzheng@youzan.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PermissionPoint {
  //权限名称
  String name();

  //权限分组
  PermissionGroup group();


}
