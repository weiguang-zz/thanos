package com.thanos.portal.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import com.thanos.portal.domain.basic.SquarePart;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
public class SquarePartStock extends Aggregate {
  @DBRef
  SquarePart squarePart;

  Long nums;//库存数量


  public SquarePartStock(SquarePart squarePart, int nums) {

  }

}
