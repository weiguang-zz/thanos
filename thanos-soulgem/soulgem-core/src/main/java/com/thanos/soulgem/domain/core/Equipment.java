package com.thanos.soulgem.domain.core;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateEquipment;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
public class Equipment extends Aggregate{

  ObjectId companyId;
  String name;
  EquipmentCategory category;
  String useTo;
  List<EquipmentParam> params;


  public Equipment(SaveOrUpdateEquipment saveOrUpdateEquipment) {
    BeanUtils.copyProperties(saveOrUpdateEquipment, this);
  }

  public void addParam(EquipmentParam param){
    params.add(param);
  }

}
