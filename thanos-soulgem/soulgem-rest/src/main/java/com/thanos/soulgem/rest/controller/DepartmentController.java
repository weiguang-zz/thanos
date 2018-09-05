package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.DepartmentApp;
import com.thanos.soulgem.domain.identity.Department;
import com.thanos.soulgem.domain.identity.command.DepartmentSave;
import com.thanos.soulgem.domain.identity.command.DepartmentUpdate;
import com.thanos.soulgem.rest.check.InputAssert;
import com.thanos.soulgem.rest.dto.Page;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 9/5/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
  @Autowired
  DepartmentApp departmentApp;


  @GetMapping
  public Page<Department> list(@RequestParam("companyId")ObjectId companyId,
      @PageableDefault Pageable pageable){
    return Page.of(departmentApp.list(companyId,pageable));
  }

  @PostMapping
  public void save(@RequestBody DepartmentSave add){
    add.validate();
    departmentApp.save(add);
  }
  @PutMapping("/{id}")
  public void update(@PathVariable("id") ObjectId departmentId,
      @RequestBody DepartmentUpdate update){
    update.validate();
    departmentApp.update(departmentId, update);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id")ObjectId departmentId){
    InputAssert.notNull(departmentId, "id");
    departmentApp.delete(departmentId);
  }


}
