package com.thanos.soulgem.domain.authority;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
public interface PermissionRepo extends PagingAndSortingRepository<Permission, ObjectId>{

}
