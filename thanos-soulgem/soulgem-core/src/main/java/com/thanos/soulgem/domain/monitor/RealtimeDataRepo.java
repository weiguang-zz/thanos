package com.thanos.soulgem.domain.monitor;

import com.thanos.common.domain.RealtimeData;
import com.thanos.soulgem.domain.identity.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by zhangzheng on 8/21/18
 * Email:zhangzheng@youzan.com
 */
public interface RealtimeDataRepo extends MongoRepository<RealtimeData,ObjectId> {

}
