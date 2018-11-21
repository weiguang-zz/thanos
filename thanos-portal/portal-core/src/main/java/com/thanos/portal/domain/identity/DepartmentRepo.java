package com.thanos.portal.domain.identity;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 9/2/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface DepartmentRepo extends MongoRepository<Department,ObjectId> {

  Page<Department> findByCompanyId(ObjectId companyId, Pageable pageable);

}
