package com.thanos.common.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface RealTimeDataRepo extends MongoRepository<RealTimeData,ObjectId> {

}
