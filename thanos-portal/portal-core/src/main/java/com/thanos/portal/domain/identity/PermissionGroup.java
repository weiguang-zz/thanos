package com.thanos.portal.domain.identity;

/**
 * Create by zhangzheng on 8/26/18
 * Email:zhangzheng@youzan.com
 */
public enum PermissionGroup {
  Equipment("设备管理"),
  Operating("运行维护"),
  SquarePart("备件"),
  System("系统设置");


  private String value;

  PermissionGroup(String value) {
    this.value = value;
  }

  public String value(){
    return value;
  }
}
