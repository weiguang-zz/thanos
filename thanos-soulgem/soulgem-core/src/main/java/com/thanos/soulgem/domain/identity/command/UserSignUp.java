package com.thanos.soulgem.domain.identity.command;

import com.thanos.common.domain.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
  @Size(min = 5, max = 30)
  String username;

}
