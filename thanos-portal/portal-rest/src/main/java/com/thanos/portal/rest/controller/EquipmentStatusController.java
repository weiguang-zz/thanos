package com.thanos.portal.rest.controller;

import com.thanos.portal.domain.monitor.RealTimeData;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 11/24/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/equipmentStatus")
public class EquipmentStatusController {

  /**
   * @return
   */
  @PostMapping

  public List<RealTimeData> calc(List<RealTimeData> originRealTimeDatas){
    return null;
  }

}
