package com.thanos.soulgem.app;

import com.thanos.common.domain.exception.BizAssert;
import com.thanos.soulgem.domain.identity.Department;
import com.thanos.soulgem.domain.identity.DepartmentRepo;
import com.thanos.soulgem.domain.identity.PermissionGroup;
import com.thanos.soulgem.domain.identity.PermissionPoint;
import com.thanos.soulgem.domain.identity.command.DepartmentAdd;
import com.thanos.soulgem.domain.identity.command.DepartmentUpdate;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class DepartmentApp {

  @Autowired
  DepartmentRepo departmentRepo;

  @PermissionPoint(name = "新增部门", group = PermissionGroup.System)
  public void save(DepartmentAdd add){
    Department department = new Department(add.getCompanyId(), add.getName(),
        add.getTelephone(),add.getRemark());
    if(add.getParent()!=null){
      BizAssert.check(departmentRepo.existsById(add.getParent()), "父部门不存在");
      department.setParent(departmentRepo.findById(add.getParent()).get());
    }
    departmentRepo.save(department);
  }
  @PermissionPoint(name = "更新部门", group = PermissionGroup.System)
  public void update(ObjectId id, DepartmentUpdate update){
    BizAssert.check(departmentRepo.existsById(id), "department id not exist");
    Department department = departmentRepo.findById(id).get();
    department.merge(update);
    if(update.getParent()!=null){
      BizAssert.check(departmentRepo.existsById(update.getParent()), "父部门不存在");
      department.setParent(departmentRepo.findById(update.getParent()).get());
    }
    departmentRepo.save(department);
  }

  @PermissionPoint(name = "删除部门", group = PermissionGroup.System)
  public void delete(ObjectId id){
    BizAssert.check(departmentRepo.existsById(id), "department id not exist");
    departmentRepo.deleteById(id);
  }


  public Page<Department> list(ObjectId companyId, Pageable pageable){
    return departmentRepo.findByCompanyId(companyId, pageable);
  }


}
