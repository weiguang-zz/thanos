package com.thanos.portal.domain.squarepart;

import com.thanos.common.domain.Aggregate;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 * 备件计划项
 */
public class PlanItem extends Aggregate{

  ObjectId squarePartId;//备件Id
  ObjectId planId;//备件计划Id
  Long nums;
  ObjectId suggestedVendor;//建议厂家
  ObjectId declaredDepartment;//申报部门
  String declaredReason;//申报原因
}
