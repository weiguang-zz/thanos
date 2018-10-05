package com.thanos.soulgem.domain.audit;

import com.thanos.common.domain.ValueObject;
import java.util.List;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class AuditNode {
  String name;
  List<String> auditUsers;

  public AuditNode(String name, List<String> auditUsers) {
    this.name = name;
    this.auditUsers = auditUsers;
  }
}
