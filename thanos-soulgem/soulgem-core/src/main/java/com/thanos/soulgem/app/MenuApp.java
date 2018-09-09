package com.thanos.soulgem.app;

import com.thanos.soulgem.domain.basic.Menu;
import com.thanos.soulgem.domain.basic.MenuRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 9/3/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class MenuApp {

  @Autowired
  MenuRepo menuRepo;

  //查询所有的菜单
  public List<Menu> list(){
    return menuRepo.findAll();
  }

  //更新所有菜单
  public void update(List<Menu> menus){
    menuRepo.deleteAll();
    menuRepo.saveAll(menus);
  }

}
