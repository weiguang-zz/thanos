package com.thanos.soulgem.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.Equipment;
import com.thanos.soulgem.domain.basic.EquipmentCategory;
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
  ObjectId categoryId;
  @NotNull
  String useTo;

  List<EquipmentParam> params;
  @ApiModelProperty(hidden = true)
  EquipmentCategory category;

  public Equipment build(){
    Equipment equipment = new Equipment(companyId, name, category, useTo, params);
    return equipment;
  }
}
