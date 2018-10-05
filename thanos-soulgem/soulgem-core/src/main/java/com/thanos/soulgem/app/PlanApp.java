package com.thanos.soulgem.app;

import com.thanos.soulgem.domain.audit.AuditFlow;
import com.thanos.soulgem.domain.audit.AuditFlowRepo;
import com.thanos.soulgem.domain.audit.enums.AuditFlowTargetType;
import com.thanos.soulgem.domain.squarepart.Plan;
import com.thanos.soulgem.domain.squarepart.PlanRepo;
import com.thanos.soulgem.domain.squarepart.command.PlanSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class PlanApp {
  @Autowired
  PlanRepo planRepo;

  @Autowired
  AuditFlowRepo auditFlowRepo;

  public void save(PlanSaveCommand planSaveCommand) {
    Plan plan = new Plan();//todo
    planRepo.save(plan);
    AuditFlow auditFlow = new AuditFlow(AuditFlowTargetType.plan, plan.id(), planSaveCommand.getAuditNodes());
    auditFlowRepo.save(auditFlow);

  }
}
