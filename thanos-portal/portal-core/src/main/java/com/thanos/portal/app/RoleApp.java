package com.thanos.portal.app;

import com.thanos.common.domain.exception.BizAssert;
import com.thanos.portal.domain.basic.MenuRepo;
import com.thanos.portal.domain.identity.Permission;
import com.thanos.portal.domain.identity.PermissionGroup;
import com.thanos.portal.domain.identity.PermissionPoint;
import com.thanos.portal.domain.identity.PermissionRepo;
import com.thanos.portal.domain.identity.Role;
import com.thanos.portal.domain.identity.RoleRepo;
import com.thanos.portal.domain.identity.command.RoleSave;
import com.thanos.portal.domain.identity.command.RoleUpdate;
import java.util.List;
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
public class RoleApp {

  @Autowired
  RoleRepo roleRepo;
  @Autowired
  PermissionRepo permissionRepo;
  @Autowired
  MenuRepo menuRepo;

  @PermissionPoint(name = "创建角色", group = PermissionGroup.System)
  public void save(RoleSave roleSave){
    Role role = new Role(roleSave.getCompanyId(), roleSave.getName(), roleSave.getCreatedBy(), roleSave
        .getRemark());
    role.assginPermissions(roleSave.getPermissions());
    role.assginMenus(roleSave.getMenus());
    roleRepo.save(role);
  }
  @PermissionPoint(name = "更新角色", group = PermissionGroup.System)
  public void update(ObjectId id, RoleUpdate roleUpdate){
    BizAssert.check(roleRepo.existsById(id), "role id not exist");
    Role role = roleRepo.findById(id).get();
    role.updateName(roleUpdate.getName());
    role.updateRemark(roleUpdate.getRemark());
    role.assginPermissions(roleUpdate.getPermissions());
    role.assginMenus(roleUpdate.getMenus());
    roleRepo.save(role);
  }
  @PermissionPoint(name = "删除角色", group = PermissionGroup.System)
  public void delete(ObjectId id){
    BizAssert.check(roleRepo.existsById(id), "role id not exist");
    roleRepo.deleteById(id);
  }

  public Page<Role> list(ObjectId companyId, Pageable pageable){
    return roleRepo.findByCompanyId(companyId, pageable);
  }

  //查询数据库中所有的权限点
  public List<Permission> allPermissions(){
    return permissionRepo.findAll();
  }


}
