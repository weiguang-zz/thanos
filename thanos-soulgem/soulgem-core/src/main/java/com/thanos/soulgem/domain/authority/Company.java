package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.Aggregate;

/**
 * Create by zhangzheng on 7/24/18
 * Email:zhangzheng@youzan.com
 */
@Aggregate
public class Company {
  String name;

  Company parent;

  String telephone;

}
