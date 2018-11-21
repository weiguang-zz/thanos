package com.thanos.portal.rest.dto;

import java.util.List;
import lombok.Data;

/**
 * Create by zhangzheng on 5/25/18
 * Email:zhangzheng@youzan.com
 */
@Data
public class Page<T> {

  long pageSize;
  long totalItems;
  List<T> items;

  public static <T> Page<T> of(org.springframework.data.domain.Page<T> page){
    Page instance = new Page();
    instance.pageSize = page.getSize();
    instance.totalItems = page.getTotalElements();
    instance.items = page.getContent();
    return instance;

  }

}
