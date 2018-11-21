package com.thanos.portal.app;

import com.thanos.portal.domain.audit.AuditFlow;
import com.thanos.portal.domain.audit.AuditFlowRepo;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class AuditFlowApp {
  @Autowired
  AuditFlowRepo auditFlowRepo;

  public List<AuditFlow> findMyAuditFlow(String username) {
    return auditFlowRepo.findMyAuditFlow(username);
  }

  public void audit(ObjectId auditFlowId, boolean accepted, String remark, String user) {
    AuditFlow auditFlow = auditFlowRepo.findById(auditFlowId).get();
    auditFlow.audit(user,accepted, remark);
    auditFlowRepo.save(auditFlow);
  }

  public AuditFlow detail(ObjectId id) {
    return auditFlowRepo.findById(id).get();
  }
}
