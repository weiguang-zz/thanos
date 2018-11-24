package com.thanos.spm.app;

import com.thanos.spm.domain.supplier.Supplier;
import com.thanos.spm.domain.supplier.command.SupplierSave;
import com.thanos.spm.repo.supplier.SupplierRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiliang
 * @date 2018/11/24
 */
@Service
public class SupplierService {


  @Resource
  private SupplierRepo supplierRepo;


  /**
   * 通过供应商名称和等级 分页获取 供应商列表
   * @param name
   * @param pageable
   * @return
   */
  public Page<Supplier> findSupplierListByNameAndLevel(String name, Integer level, Pageable pageable) {
    return supplierRepo.findByNameAndLevel(name,level, pageable);
  }

  public void saveSupplier(SupplierSave supplierSave){
    supplierRepo.save(supplierSave.build());
  }

}
