package com.thanos.soulgem.domain.authority.command;

import com.thanos.soulgem.domain.authority.User;
import com.thanos.soulgem.domain.common.Validator;
import javax.validation.Validation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class UserSignUp extends Validator<UserSignUp> {
  @NotNull
  ObjectId companyId;

  @NotNull
  String username;

  @NotNull
  @Min(5)
  @Max(30)
  String password;

}
