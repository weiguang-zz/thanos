package com.thanos.portal.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
public class ReceiptItem extends Aggregate{
  @DBRef
  SquarePartInstance instance;
  Long nums;//数量

  public ReceiptItem(SquarePartInstance squarePartInstance, long nums) {
    this.instance = squarePartInstance;
    this.nums = nums;

  }
}
