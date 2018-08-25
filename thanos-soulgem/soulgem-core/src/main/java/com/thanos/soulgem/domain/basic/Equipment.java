package com.thanos.soulgem.domain.basic;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateEquipment;
import java.util.List;
import org.bson.types.ObjectId;

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

  public Equipment(ObjectId companyId, String name,
      EquipmentCategory category, String useTo, List<EquipmentParam> params) {
    this.companyId = companyId;
    this.name = name;
    this.category = category;
    this.useTo = useTo;
    this.params = params;
  }

  /**
   * 合并修改
   * @param saveOrUpdateEquipment
   */
  public void merge(SaveOrUpdateEquipment saveOrUpdateEquipment){
    this.name = saveOrUpdateEquipment.getName();
    this.category = saveOrUpdateEquipment.getCategory();
    this.useTo = saveOrUpdateEquipment.getUseTo();
    this.params = saveOrUpdateEquipment.getParams();
  }

  public void addParam(EquipmentParam param){
    params.add(param);
  }

}
