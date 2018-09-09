package com.thanos.soulgem.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.Equipment;
import com.thanos.soulgem.domain.basic.EquipmentParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
@ApiModel
public class EquipmentSave extends Validator<EquipmentSave> {

  @NotNull
  ObjectId companyId;
  @NotNull
  String name;
  @NotNull
  String category;
  @NotNull
  String useTo;
  @NotNull @ApiModelProperty("规格型号")
  String specification;
  @NotNull @ApiModelProperty("设备编号")
  Long number;//设备编号
  @NotNull @ApiModelProperty("厂家")
  String vendor; //厂家

  List<EquipmentParam> params;


  public Equipment build(){
    Equipment equipment = new Equipment(companyId, name, category, useTo, params,specification, number, vendor);
    return equipment;
  }
}
