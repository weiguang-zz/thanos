package com.thanos.soulgem.domain.identity;

import com.thanos.common.domain.DomainService;
import com.thanos.common.domain.exception.AuthorizationException;
import com.thanos.common.domain.exception.ResultCase.Id;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
@DomainService
@Service
@Aspect
@Slf4j
public class ValidationAspect {

  @Autowired(required = false)
  UserHolder userHolder;

  @Pointcut("@annotation(permissionPoint)")
  public void anyPermissionPoint(PermissionPoint permissionPoint) {
  }

  @Before("anyPermissionPoint(permissionPoint)")
  public void validate(JoinPoint joinPoint, PermissionPoint permissionPoint){
    String permissionName = permissionPoint.name();
    String methodGenericString = joinPoint.getSignature().toLongString();

    User loginedUser = userHolder.getUser();
    if(!loginedUser.hasPermission(methodGenericString)){
      String message = String.format("user:%s has no permission to %s", loginedUser.username,
          permissionName);
      log.error(message);
      throw new AuthorizationException(Id.permission_deny, message);
    }

  }



}
