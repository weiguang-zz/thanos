package com.thanos.soulgem.domain.basic;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */

public class EquipmentCategory extends Aggregate{
  //分类名称
  String name;
  //父级目录
  ObjectId parent;

}
