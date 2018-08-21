package com.thanos.soulgem.domain.core;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateSquarePart;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
public class SquarePart extends Aggregate {

  ObjectId equipmentId;
  String name;
  String specifications;//规格型号
  String installLocation;
  String unit;
  Long initialAmount;//装机数量
  String technicalParameters;//技术参数
  String others;

  public SquarePart(SaveOrUpdateSquarePart saveOrUpdateSquarePart) {
    BeanUtils.copyProperties(saveOrUpdateSquarePart, this);
  }
}
