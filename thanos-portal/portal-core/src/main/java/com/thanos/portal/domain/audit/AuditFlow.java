package com.thanos.portal.domain.audit;

import com.thanos.common.domain.Aggregate;
import com.thanos.common.domain.exception.BizAssert;
import com.thanos.common.domain.exception.BusinessException;
import com.thanos.common.domain.exception.ResultCase.Id;
import com.thanos.portal.domain.audit.enums.AuditFlowTargetType;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
public class AuditFlow extends Aggregate{

  AuditFlowTargetType type;
  ObjectId targetId;
  List<AuditNode> auditNodes;
  AuditNode nextNode;
  List<AuditRecord> auditRecords = new ArrayList<>();
  Boolean finished = false;
  private int position;

  public boolean finished(){
    return finished;
  }

  public AuditFlow(AuditFlowTargetType type, ObjectId targetId,
      List<AuditNode> auditNodes) {
    this.type = type;
    this.targetId = targetId;
    BizAssert.check((auditNodes!=null && !auditNodes.isEmpty()), "audit nodes can not be empty" );
    this.auditNodes = auditNodes;
    this.nextNode = auditNodes.get(0);
    this.position = 0;
  }

  public void audit(String auditUser, Boolean accepted, String remark){
    if(finished){
      throw new BusinessException(Id.biz_constraint_violated, "the audit flow already finished");
    }
    BizAssert.check(nextNode.auditUsers.contains(auditUser),"the user {} has no right to audit", auditUser);
    AuditRecord auditRecord = new AuditRecord(auditUser,accepted, remark);
    auditRecords.add(auditRecord);
    position++;
    if(position>=auditNodes.size()){
      this.finished = true;

      this.nextNode = null;
    }else{
      this.nextNode = auditNodes.get(position);
    }
  }


}
