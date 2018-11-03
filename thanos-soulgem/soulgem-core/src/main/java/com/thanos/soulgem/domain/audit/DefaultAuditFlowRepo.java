package com.thanos.soulgem.domain.audit;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 10/6/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface DefaultAuditFlowRepo extends MongoRepository<DefaultAuditFlow,ObjectId> {

}
