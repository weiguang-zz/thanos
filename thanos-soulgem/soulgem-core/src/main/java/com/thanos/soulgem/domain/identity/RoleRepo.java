package com.thanos.soulgem.domain.identity;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by zhangzheng on 7/21/18
 * Email:zhangzheng@youzan.com
 */
public interface RoleRepo extends MongoRepository<Role, ObjectId> {

  Page<Role> findByCompanyId(ObjectId companyId, Pageable pageable);

}
