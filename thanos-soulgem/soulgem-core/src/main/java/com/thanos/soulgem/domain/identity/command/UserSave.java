package com.thanos.soulgem.domain.identity.command;

import com.thanos.common.domain.Validator;
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

  @NotNull
  String realname;
  @Pattern(regexp = "^\\d+$", message = "手机号非法")
  String mobile;

  ObjectId departmentId;

  List<ObjectId> roleIds = Collections.emptyList();

}
