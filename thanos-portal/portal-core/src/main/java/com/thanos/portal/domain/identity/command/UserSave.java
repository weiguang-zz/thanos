package com.thanos.portal.domain.identity.command;

import com.thanos.common.domain.Validator;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class UserSave extends Validator<UserSave> {
  @NotNull
  ObjectId companyId;

  @NotNull
  @Size(min = 5, max = 30)
  String username;

  @NotNull @ApiModelProperty("真实姓名")
  String realname;
  @Pattern(regexp = "^\\d+$", message = "手机号非法")
  String mobile;
  @ApiModelProperty("部门id")
  ObjectId departmentId;
  @ApiModelProperty("给用户分配的角色列表")
  List<ObjectId> roleIds = Collections.emptyList();

}
