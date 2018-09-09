package com.thanos.common.utils;

import com.thanos.common.domain.exception.ApplicationException;
import com.thanos.common.domain.exception.ResultCase;
import com.thanos.common.domain.exception.ResultCase.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.util.ReflectionUtils;

/**
 * Create by zhangzheng on 9/9/18
 * Email:zhangzheng@youzan.com
 */
public abstract class BeanUtils {

  /**
   * 该方法相比较于Spring的BeanUtils，支持设置desc的私有属性
   * @param src
   * @param dest
   * @param ignoreProperties
   * @throws IllegalAccessException
   */
  public static void copyProperties(Object src, Object dest, String... ignoreProperties) {
    //todo need test
    try {
      List<Field> destFields = new ArrayList<>();
      ReflectionUtils.doWithLocalFields(dest.getClass(), f -> destFields.add(f));
      Set ignores = new HashSet<>(Arrays.asList(ignoreProperties));
      for(Field destField: destFields){
        if(ignores.contains(destField.getName())) continue;
        boolean isAccessible = destField.isAccessible();
        destField.setAccessible(true);
        Field srcField = ReflectionUtils.findField(src.getClass(), destField.getName());
        boolean srcAccessible = srcField.isAccessible();
        srcField.setAccessible(true);
        destField.set(dest, srcField.get(src));
        srcField.setAccessible(srcAccessible);
        destField.setAccessible(isAccessible);
      }
    } catch (IllegalAccessException e) {
      throw new ApplicationException(new ResultCase(Id.application_error,e.getMessage()), e);
    }

  }

}
