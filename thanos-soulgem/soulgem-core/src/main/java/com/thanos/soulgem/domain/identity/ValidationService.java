package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.DomainService;
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

  public boolean validatePermission(String username, String className,String methodGenericString){
    User user = userRepo.findByUsername(username);
    return user.hasPermission(className, methodGenericString);
  }

}
