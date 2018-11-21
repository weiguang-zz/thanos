package com.thanos.portal.domain.basic;

import com.thanos.common.domain.Aggregate;
import com.thanos.common.utils.BeanUtils;
import com.thanos.portal.domain.basic.command.LubricatingCardUpdate;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
public class LubricatingCard extends Aggregate {

  ObjectId equipmentId;
  String position;
  String oilSpecifications;
  Double amount;//润滑点数
  String type;//润滑方式
  Double initialOilAmount;//初装油量
  Double standardOilAmount;//标准油量
  Double supplyOilAmount;// 补给油量
  Double lubricatingPeriod;//润滑周期
  Double temperature;//标准温度

  public void merge(LubricatingCardUpdate update){
    BeanUtils.copyProperties(update, this);
  }

  public ObjectId equipmentId(){
    return equipmentId;
  }
}
