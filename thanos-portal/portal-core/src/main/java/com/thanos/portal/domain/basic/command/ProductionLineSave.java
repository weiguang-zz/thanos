package com.thanos.portal.domain.basic.command;

import java.util.List;
import lombok.Data;
import org.bson.types.ObjectId;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class ProductionLineSave {
  ObjectId companyId;
  String name;
  Long number;
  List<Process> processes;


}
