package com.thanos.soulgem.domain.core.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.core.EquipmentCategory;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class SaveOrUpdateEquipment extends Validator<SaveOrUpdateEquipment> {
  ObjectId id;

  @NotNull
  ObjectId companyId;
  @NotNull
  String name;
  @NotNull
  EquipmentCategory category;
  @NotNull
  String useTo;

}
