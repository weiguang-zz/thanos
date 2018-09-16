package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.EquipmentApp;
import com.thanos.soulgem.app.MenuApp;
import com.thanos.soulgem.app.RoleApp;
import com.thanos.soulgem.domain.basic.EquipmentCategory;
import com.thanos.soulgem.domain.basic.Menu;
import com.thanos.soulgem.domain.identity.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangzheng on 9/3/18
 * Email:zhangzheng@youzan.com
 */
@RestController
public class ValueObjectController {
  @Autowired
  RoleApp roleApp;
  @Autowired
  MenuApp menuApp;
  @Autowired
  EquipmentApp equipmentApp;

  @GetMapping("/permissions")
  public Map<String,List<Permission>> allPermissions(){
    List<Permission> permissions = roleApp.allPermissions();
    return permissions.stream().collect(
        Collectors.toMap(Permission::group,
            val -> Arrays.asList(val),
            (oldVal,newVal)-> {
              List<Permission> combine = new ArrayList<>();
              combine.addAll(oldVal);
              combine.addAll(newVal);
              return combine;
            }));
  }

  @GetMapping("/menus")
  public List<Menu> allMenus(){
    return menuApp.list();
  }

  @PutMapping("/menus")
  public void updateAllMenus(List<Menu> menus){
    menuApp.update(menus);
  }

  @GetMapping("/categories")
  public List<EquipmentCategory> categories(){
     return equipmentApp.categories();
  }



}
