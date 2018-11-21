package com.thanos.portal.domain.basic;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface EquipmentRepo extends MongoRepository<Equipment,ObjectId> {

}
