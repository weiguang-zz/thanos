package com.thanos.portal.domain.basic;

import com.thanos.common.domain.ValueObject;
import com.thanos.portal.domain.basic.enums.AssetStatus;
import java.util.Date;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 */
@ValueObject
public class Asset {
  String source;
  Double originalValue;
  Double yearDeprecition;
  Double netValue;
  Date useTime;
  AssetStatus status;

}
