package com.thanos.portal.domain.basic;

import com.thanos.common.domain.ValueObject;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
@Document
public class EquipmentCategory{
  //分类名称
  String name;
  List<EquipmentCategory> children;

}
