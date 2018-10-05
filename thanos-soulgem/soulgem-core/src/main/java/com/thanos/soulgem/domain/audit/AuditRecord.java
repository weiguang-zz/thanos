package com.thanos.soulgem.domain.audit;

import com.thanos.common.domain.ValueObject;
import java.util.Date;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class AuditRecord {
  String auditUser;
  Date date;
  Boolean isAccepted;
  String remark;

  public AuditRecord(String auditUser, Boolean isAccepted, String remark) {
    this.auditUser = auditUser;
    this.isAccepted = isAccepted;
    this.remark = remark;
  }
}
