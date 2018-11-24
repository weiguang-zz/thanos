package com.thanos.spm.domain.supplier;

import com.thanos.common.domain.Aggregate;

import lombok.Data;

/**
 * 供应商聚合信息
 *
 * @author qiliang
 * @date 2018/11/24
 */
@Data
public class Supplier extends Aggregate {


  /**
   * 供应商名称
   */
  private String name;


  /**
   * 传真
   */
  private String facsimile;

  /**
   * 级别
   * 0 不合格 5 合格 10 优良
   */
  private Integer level;

  public Supplier(String name, String facsimile, Integer level) {
    this.name = name;
    this.facsimile = facsimile;
    this.level = level;
  }
}
