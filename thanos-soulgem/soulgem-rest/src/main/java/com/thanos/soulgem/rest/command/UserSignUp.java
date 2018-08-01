package com.thanos.soulgem.rest.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class UserSignUp {
  @NotNull
  String companyName;
  @NotNull
  String username;

  @Min(5)
  @Max(30)
  String password;

}
