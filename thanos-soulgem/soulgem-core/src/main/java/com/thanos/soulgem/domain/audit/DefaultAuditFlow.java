package com.thanos.soulgem.domain.audit;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.audit.enums.AuditFlowTargetType;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */

public class DefaultAuditFlow extends Aggregate{
  ObjectId companyId;
  AuditFlowTargetType type;
  ObjectId departmentId;
  List<AuditNode> auditNodes;

  public DefaultAuditFlow(ObjectId companyId,
      AuditFlowTargetType type, ObjectId departmentId,
      List<AuditNode> auditNodes) {
    this.companyId = companyId;
    this.type = type;
    this.departmentId = departmentId;
    this.auditNodes = auditNodes;
  }

}
