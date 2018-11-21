package com.thanos.portal.domain.basic;

import com.thanos.common.domain.Aggregate;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 */
public class ProductionLine extends Aggregate{
  ObjectId companyId;
  String name;
  Long number;//编号
  List<Process> processes;

  public List<Process> processes(){
    return processes;
  }
}
