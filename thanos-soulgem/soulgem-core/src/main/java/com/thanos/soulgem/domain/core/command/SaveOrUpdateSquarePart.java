package com.thanos.soulgem.domain.core.command;

import com.thanos.common.domain.Validator;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class SaveOrUpdateSquarePart extends Validator<SaveOrUpdateSquarePart> {
  ObjectId id;

  @NotNull
  ObjectId equipmentId;
  @NotNull
  String name;
  @NotNull
  String specifications;//规格型号
  @NotNull
  String installLocation;
  @NotNull
  String unit;
  @NotNull
  Long initialAmount;//装机数量
  @NotNull
  String technicalParameters;//技术参数

  String others;


}
