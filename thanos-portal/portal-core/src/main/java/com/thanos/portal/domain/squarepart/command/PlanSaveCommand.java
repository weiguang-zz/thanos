package com.thanos.portal.domain.squarepart.command;

import com.thanos.common.domain.Validator;
import com.thanos.portal.domain.audit.AuditNode;
import java.util.List;
import lombok.Data;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class PlanSaveCommand extends Validator<PlanSaveCommand> {

  List<AuditNode> auditNodes;

}
