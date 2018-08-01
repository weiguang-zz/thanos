package com.thanos.soulgem.domain.authority;

import com.thanos.soulgem.domain.common.DomainService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
@DomainService
@Service
public class ValidationService {

  @Resource
  UserRepo userRepo;

  public boolean validatePermission(String companyName,String username, String url){
    User user = userRepo.findByUsernameAndCompany_Name(username,companyName);
    return user.hasPermission(url);
  }

}
