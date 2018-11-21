package com.thanos.portal.domain.basic.command;

import com.thanos.common.domain.Validator;
import com.thanos.common.utils.BeanUtils;
import com.thanos.portal.domain.basic.SquarePart;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class SquarePartSave extends Validator<SquarePartSave> {

  ObjectId equipmentId;
  @NotNull
  String name;
  @NotNull @ApiModelProperty("规格型号")
  String specifications;//规格型号
  @NotNull @ApiModelProperty("安装位置")
  String installLocation;
  @NotNull @ApiModelProperty("单位")
  String unit;
  @NotNull @ApiModelProperty("装机数量")
  Long initialAmount;//装机数量
  @NotNull @ApiModelProperty("技术参数")
  String technicalParameters;//技术参数
  @ApiModelProperty("技术要求")
  String technicalRequirement;
  @ApiModelProperty("风险储备")
  Long riskyReserve;

  String others;

  public SquarePart build(){
    SquarePart squarePart = new SquarePart();
    BeanUtils.copyProperties(this, squarePart);
    return squarePart;
  }


}
