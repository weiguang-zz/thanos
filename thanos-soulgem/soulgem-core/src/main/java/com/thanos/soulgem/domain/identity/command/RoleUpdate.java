package com.thanos.soulgem.domain.identity.command;

import com.thanos.common.domain.Validator;
import com.thanos.soulgem.domain.basic.Menu;
import com.thanos.soulgem.domain.identity.Permission;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class RoleUpdate extends Validator<RoleUpdate> {
  @NotNull
  String name;

  String remark;
  List<Permission> permissions = Collections.emptyList();

  List<Menu> menus = Collections.emptyList();


}
