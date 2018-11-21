package com.thanos.portal.domain.basic;

import com.thanos.common.domain.ValueObject;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class EquipmentParam {
  String name;
  String value;

  public EquipmentParam(String name, String value) {
    this.name = name;
    this.value = value;
  }

  //for deSerialize
  public EquipmentParam(){

  }

}
