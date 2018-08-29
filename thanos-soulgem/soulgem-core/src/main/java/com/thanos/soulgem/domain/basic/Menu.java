package com.thanos.soulgem.domain.basic;

import com.thanos.common.domain.ValueObject;
import java.util.List;

/**
 * Create by zhangzheng on 8/26/18
 * Email:zhangzheng@youzan.com
 *
 */
@ValueObject
public class Menu {

  String name;
  String path;
  List<Menu> children;
  String icon;

}
