package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.RoleApp;
import com.thanos.soulgem.domain.identity.Role;
import com.thanos.soulgem.domain.identity.command.RoleSave;
import com.thanos.soulgem.domain.identity.command.RoleUpdate;
import com.thanos.soulgem.rest.dto.Page;
import io.swagger.annotations.ApiOperation;
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
 * Create by zhangzheng on 9/3/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
  @Autowired
  RoleApp roleApp;

  @ApiOperation("获取角色列表")
  @GetMapping
  public Page<Role> list(@RequestParam("companyId") ObjectId companyId, @PageableDefault Pageable pageable){
    return Page.of(roleApp.list(companyId, pageable));
  }
  @PostMapping
  public void save(@RequestBody RoleSave roleSave){
    roleApp.save(roleSave);
  }
  @PutMapping("/{id}")
  public void update(@PathVariable("id")ObjectId roleId, @RequestBody RoleUpdate roleUpdate){
    roleApp.update(roleId, roleUpdate);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id")ObjectId roleId){
    roleApp.delete(roleId);
  }

}
