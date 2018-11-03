package com.thanos.soulgem.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
public class Receipt extends Aggregate{

  @DBRef
  List<ReceiptItem> receiptItems;

  public Receipt(List<ReceiptItem> receiptItems) {
    this.receiptItems = receiptItems;
  }
}
