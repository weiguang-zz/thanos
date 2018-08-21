package com.thanos.soulgem.domain.core.command;

import com.thanos.common.domain.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class SaveOrUpdateLubricatingCard extends Validator<SaveOrUpdateLubricatingCard> {

  ObjectId id;
  @NotNull
  ObjectId equipmentId;
  @NotNull
  String position;
  @NotNull
  String oilSpecifications;
  @NotNull
  @Min(1)
  Double amount;//润滑点数
  @NotNull
  String type;//润滑方式
  @NotNull
  @Min(0)
  Double initialOilAmount;//初装油量
  @NotNull
  @Min(0)
  Double supplyOilAmount;// 补给油量
  @NotNull
  @Min(0)
  Double lubricatingPeriod;//润滑周期
  @NotNull
  @Min(0)
  Double temperature;//标准温度

}
