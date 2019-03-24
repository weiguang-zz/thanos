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
   * id
   */
  private Long id;

  /**
   * 供应商名称
   */
  private String name;

  /**
   * 状态 0 被删除
   */
  private Integer state;


  /**
   * 传真
   */
  private String facsimile;

  /**
   * 级别
   * 0 不合格 5 合格 10 优良
   */
  private Integer level;

  public Supplier(Long id,String name, String facsimile, Integer state,Integer level) {
    this.id = id;
    this.state = state;
    this.name = name;
    this.facsimile = facsimile;
    this.level = level;
  }
}
