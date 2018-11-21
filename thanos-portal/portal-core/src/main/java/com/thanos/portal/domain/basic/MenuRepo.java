package com.thanos.portal.domain.basic;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface MenuRepo extends MongoRepository<Menu,ObjectId> {

}
