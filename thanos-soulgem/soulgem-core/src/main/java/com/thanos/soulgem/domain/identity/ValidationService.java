package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.DomainService;
import javax.annotation.Resource;
import org.bson.types.ObjectId;
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

  public boolean validatePermission(ObjectId companyId,String username, String url){
    User user = userRepo.findByUsernameAndCompany(username,companyId);
    return user.hasPermission(url);
  }

}
