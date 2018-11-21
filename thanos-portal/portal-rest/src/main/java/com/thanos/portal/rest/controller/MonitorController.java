package com.thanos.portal.rest.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 11/3/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/monitors")
public class MonitorController {

  @PostMapping
  @ApiOperation(value = "新增测点")
  public void save(){

  }

}
