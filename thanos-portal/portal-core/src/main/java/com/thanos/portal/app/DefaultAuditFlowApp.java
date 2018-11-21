package com.thanos.portal.app;

import com.thanos.portal.domain.audit.DefaultAuditFlow;
import com.thanos.portal.domain.audit.DefaultAuditFlowRepo;
import com.thanos.portal.domain.audit.command.DefaultAuditFlowSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class DefaultAuditFlowApp {
  @Autowired
  DefaultAuditFlowRepo defaultAuditFlowRepo;

  public void save(DefaultAuditFlowSaveCommand saveCommand){

    DefaultAuditFlow defaultAuditFlow = new DefaultAuditFlow(saveCommand.getCompanyId()
        ,saveCommand.getType(), saveCommand.getDepartmentId(), saveCommand.getAuditNodes());
    defaultAuditFlowRepo.save(defaultAuditFlow);

  }

}
