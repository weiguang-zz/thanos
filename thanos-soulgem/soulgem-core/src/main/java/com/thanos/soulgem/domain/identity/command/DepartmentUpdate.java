package com.thanos.soulgem.domain.identity.command;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class DepartmentUpdate {

  @NotNull
  String name;
  @NotNull
  String telephone;
  ObjectId parent;
  String remark;

}
