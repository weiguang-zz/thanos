package com.thanos.soulgem.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.EquipmentParam;
import io.swagger.annotations.ApiModel;
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
public class EquipmentUpdate extends Validator<EquipmentUpdate> {

  @NotNull
  ObjectId companyId;
  @NotNull
  String name;
  @NotNull
  String category;
  @NotNull
  String useTo;
  @NotNull
  String specification;
  @NotNull
  Long number;//设备编号
  @NotNull
  String vendor; //厂家

  List<EquipmentParam> params;

}
