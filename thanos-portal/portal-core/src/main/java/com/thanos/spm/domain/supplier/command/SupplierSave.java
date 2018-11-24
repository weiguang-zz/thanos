package com.thanos.spm.domain.supplier.command;

import com.thanos.common.domain.Validator;
import com.thanos.spm.domain.supplier.Supplier;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 供应商聚合信息
 *
 * @author qiliang
 * @date 2018/11/24
 */
@Data
public class SupplierSave extends Validator<Supplier> {


  /**
   * 供应商名称
   */
  @ApiModelProperty("供应商名称")
  @NotNull
  private String name;


  /**
   * 传真
   */
  @ApiModelProperty("传真")
  @NotNull
  private String facsimile;

  /**
   * 级别
   * 0 不合格 5 合格 10 优良
   */
  @NotNull
  private Integer level;

  public Supplier build(){
    Supplier supplier = new Supplier(name,facsimile,level);
    return supplier;
  }

}
