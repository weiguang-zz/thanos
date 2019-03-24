package com.thanos.portal.rest.controller.spm;

import com.thanos.portal.rest.check.InputAssert;
import com.thanos.portal.rest.dto.Page;
import com.thanos.spm.app.SupplierService;
import com.thanos.spm.domain.supplier.Supplier;
import com.thanos.spm.domain.supplier.command.SupplierSave;
import com.thanos.spm.domain.supplier.command.SupplierStateEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    return Page.of(supplierService.findSupplierListByNameAndLevel(supplierName, level, SupplierStateEnum.CREAT.getCode(),pageable));
  }

  @PostMapping
  @ApiOperation(value = "新增一个供应商信息")
  public void saveSupplier(@RequestBody SupplierSave supplierSave) {
    supplierSave.validate();
    supplierService.saveSupplier(supplierSave);
  }

  @PostMapping
  @ApiOperation(value = "删除一个供应商信息")
  public void delSupplier(@RequestBody SupplierSave supplierSave) {
    supplierSave.validate();
    supplierService.delSupplier(supplierSave);
  }


}
