package com.thanos.portal.domain.monitor;

import com.thanos.common.domain.RealTimeData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 */
public interface RealTimeDataRepo extends MongoRepository<RealTimeData,ObjectId> {

}
