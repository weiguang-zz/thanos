package com.thanos.portal.domain.audit.command;

import com.thanos.common.domain.Validator;
import com.thanos.portal.domain.audit.enums.AuditFlowTargetType;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */

public class AuditFlowSaveCommand extends Validator<AuditFlowSaveCommand> {

  ObjectId companyId;
  List<String>[] auditNodes;
  AuditFlowTargetType targetType;


  public void setAuditNodes(List<String>... auditNodes) {
    this.auditNodes = auditNodes;
  }

  public ObjectId getCompanyId() {
    return companyId;
  }

  public void setCompanyId(ObjectId companyId) {
    this.companyId = companyId;
  }

  public List<String>[] getAuditNodes() {
    return auditNodes;
  }

  public AuditFlowTargetType getTargetType() {
    return targetType;
  }

  public void setTargetType(AuditFlowTargetType targetType) {
    this.targetType = targetType;
  }
}
