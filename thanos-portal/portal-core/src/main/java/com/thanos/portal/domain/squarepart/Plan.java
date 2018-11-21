package com.thanos.portal.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import com.thanos.portal.domain.audit.enums.AuditStatus;
import com.thanos.portal.domain.squarepart.enums.PlanType;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
public class Plan extends Aggregate{

  ObjectId companyId;
  String name;
  PlanType type;
  Date month;
  AuditStatus status;
  String createdBy;
  Date createdAt;

}
