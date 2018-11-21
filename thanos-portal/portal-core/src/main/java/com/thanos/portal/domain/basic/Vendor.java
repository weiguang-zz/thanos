package com.thanos.portal.domain.basic;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;

/**
 * Create by zhangzheng on 10/27/18
 * Email:zhangzheng@youzan.com
 */
@CompoundIndex(def = "{'companyId' : 1, 'name': 1}")
public class Vendor extends Aggregate{
  //供应商
  ObjectId companyId;
  //供应商名称
  String name;

}
