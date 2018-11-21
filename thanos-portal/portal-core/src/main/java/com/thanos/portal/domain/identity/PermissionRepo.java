package com.thanos.portal.domain.identity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface PermissionRepo extends MongoRepository<Permission, ObjectId> {

  Permission findByName(String name);

}
