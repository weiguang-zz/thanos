package com.thanos.soulgem.domain.core;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateLubricatingCard;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

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
  Double supplyOilAmount;// 补给油量
  Double lubricatingPeriod;//润滑周期
  Double temperature;//标准温度

  public LubricatingCard(SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard) {
    BeanUtils.copyProperties(saveOrUpdateLubricatingCard, this);
  }
}
