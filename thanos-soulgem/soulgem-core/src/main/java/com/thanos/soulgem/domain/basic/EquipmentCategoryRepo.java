package com.thanos.soulgem.domain.basic;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by zhangzheng on 8/25/18
 * Email:zhangzheng@youzan.com
 */
public interface EquipmentCategoryRepo extends MongoRepository<EquipmentCategory,ObjectId> {

}
