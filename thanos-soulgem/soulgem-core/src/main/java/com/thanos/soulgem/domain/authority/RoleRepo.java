package com.thanos.soulgem.domain.authority;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
public interface RoleRepo extends MongoRepository<Role, ObjectId> {

}
