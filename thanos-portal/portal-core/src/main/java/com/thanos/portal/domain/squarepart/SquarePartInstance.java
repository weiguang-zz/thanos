package com.thanos.portal.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import com.thanos.portal.domain.basic.SquarePart;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
public class SquarePartInstance extends Aggregate{
  @DBRef
  SquarePart basicInfo;

  String vendorName;


  public SquarePartInstance(SquarePart basicInfo) {
    this.basicInfo = basicInfo;

  }
}
