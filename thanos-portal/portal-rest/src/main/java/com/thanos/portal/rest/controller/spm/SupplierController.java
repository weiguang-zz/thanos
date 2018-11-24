package com.thanos.portal.rest.controller.spm;

import com.thanos.portal.rest.check.InputAssert;
import com.thanos.portal.rest.dto.Page;
import com.thanos.spm.app.SupplierService;
import com.thanos.spm.domain.supplier.Supplier;
import com.thanos.spm.domain.supplier.command.SupplierSave;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;

/**
 * Create by zhangzheng on 9/3/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/suppliers")
public class SupplierController {


  @Resource
  private SupplierService supplierService;


  @GetMapping
  @ApiOperation(value = "通过供货商名称查找供货商列表")
  public Page<Supplier> findSupplierListByName(@RequestParam("supplierName") String supplierName,
                                               @RequestParam("level") Integer level,
                             @PageableDefault Pageable pageable) {
    InputAssert.notBlank(supplierName,"supplierName");
    return Page.of(supplierService.findSupplierListByNameAndLevel(supplierName, level,pageable));
  }

  @PostMapping
  @ApiOperation(value = "新增一个供应商信息")
  public void saveSupplier(@RequestBody SupplierSave supplierSave) {
    supplierSave.validate();
    supplierService.saveSupplier(supplierSave);
  }


}
