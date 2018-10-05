package com.thanos.soulgem.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import com.thanos.soulgem.domain.audit.enums.AuditStatus;
import com.thanos.soulgem.domain.squarepart.enums.PlanType;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
public class Plan extends Aggregate{

  ObjectId companyId;
  ObjectId departmentId;
  String name;
  PlanType type;
  Date month;
  AuditStatus status;
  String createdBy;
  Date createdAt;



}
