package com.thanos.portal.app;

import com.thanos.portal.domain.audit.AuditFlow;
import com.thanos.portal.domain.audit.AuditFlowRepo;
import com.thanos.portal.domain.audit.enums.AuditFlowTargetType;
import com.thanos.portal.domain.squarepart.Plan;
import com.thanos.portal.domain.squarepart.PlanRepo;
import com.thanos.portal.domain.squarepart.command.PlanSaveCommand;
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
