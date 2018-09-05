package com.thanos.soulgem.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.LubricatingCard;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class LubricatingCardSave extends Validator<LubricatingCardSave> {

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

  public LubricatingCard build(){
    LubricatingCard lubricatingCard = new LubricatingCard();
    BeanUtils.copyProperties(this, lubricatingCard);
    return lubricatingCard;
  }

}
