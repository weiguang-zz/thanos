package com.thanos.portal.domain.audit.command;

import com.thanos.common.domain.Validator;
import com.thanos.portal.domain.audit.AuditNode;
import com.thanos.portal.domain.audit.enums.AuditFlowTargetType;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class DefaultAuditFlowSaveCommand extends Validator<DefaultAuditFlowSaveCommand>{
  @NotNull
  ObjectId companyId;
  @NotNull
  AuditFlowTargetType type;
  ObjectId departmentId;
  @NotEmpty
  List<AuditNode> auditNodes;

}
