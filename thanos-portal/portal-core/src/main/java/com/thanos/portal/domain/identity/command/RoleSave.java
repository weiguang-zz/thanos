package com.thanos.portal.domain.identity.command;

import com.thanos.common.domain.Validator;
import com.thanos.portal.domain.basic.Menu;
import com.thanos.portal.domain.identity.Permission;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class RoleSave extends Validator<RoleSave> {
  @NotNull
  ObjectId companyId;
  @NotNull
  String name;
  @ApiModelProperty("备注")
  String remark;
  @NotNull
  String createdBy;
  @ApiModelProperty("权限列表")
  List<Permission> permissions = Collections.emptyList();
  @ApiModelProperty("菜单列表")
  List<Menu> menus = Collections.emptyList();

}
