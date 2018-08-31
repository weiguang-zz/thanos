package com.thanos.soulgem.domain.identity;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

/**
 * Create by zhangzheng on 8/29/18
 * Email:zhangzheng@youzan.com
 */
public class PermissionPointBeanPostProcessor implements BeanPostProcessor,Ordered{

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    List<Method> methods = findAllMethod(bean.getClass());
    for(Method method:methods){
      PermissionPoint annotation = AnnotationUtils
          .findAnnotation(method, PermissionPoint.class);
      if (annotation == null) {
        continue;
      }
      String name = annotation.name();
      PermissionGroup permissionGroup = annotation.group();
      String methodGenericString = method.toGenericString();
      Permission permission = new Permission(name,permissionGroup.value(), methodGenericString);
      PermissionInitService.addPermission(permission);
    }
    return bean;
  }

  private List<Method> findAllMethod(Class clazz) {
    final List<Method> res = new LinkedList<>();
    ReflectionUtils.doWithMethods(clazz, new ReflectionUtils.MethodCallback() {
      @Override
      public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
        res.add(method);
      }
    });
    return res;
  }

  @Override
  public int getOrder() {
    return HIGHEST_PRECEDENCE;
  }
}
