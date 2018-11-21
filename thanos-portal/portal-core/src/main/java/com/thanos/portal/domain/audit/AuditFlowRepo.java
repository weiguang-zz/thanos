package com.thanos.portal.domain.audit;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface AuditFlowRepo extends MongoRepository<AuditFlow,ObjectId> {
  @Query("{ 'nextNode.auditUsers': { $all: [?0]},'finished': false }")
  List<AuditFlow> findMyAuditFlow(String username);

}
