package com.thanos.portal.domain.basic.command;

import com.thanos.common.domain.Validator;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 11/3/18
 * Email:zhangzheng@youzan.com
 */
@Data
@ApiModel
public class MonitorSave extends Validator<MonitorSave>{
  @NotNull
  ObjectId companyId;
  String name;
  @NotNull
  String code;


}
