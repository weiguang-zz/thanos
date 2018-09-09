package com.thanos.soulgem.domain.identity;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/26/18
 * Email:zhangzheng@youzan.com
 * 权限初始化服务
 */
@Service
@Slf4j
public class PermissionInitService implements ApplicationListener<ApplicationReadyEvent> {
  @Autowired
  PermissionRepo permissionRepo;

  static List<Permission> permissions = new ArrayList<>();

  public static void addPermission(Permission permission){
    permissions.add(permission);
  }

  //for integration tests
  public static void clearPermissions(){
    permissions.clear();
  }

  //刷新权限数据到存储中
  private void syncPermissions(){
    //因为是value object，所以整个全量替换就可以
    log.info("start to sync permissions..");
    permissionRepo.deleteAll();
    permissionRepo.saveAll(permissions);
    log.info("finished");
  }


  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    syncPermissions();
  }
}
