package com.thanos.soulgem.domain.identity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 7/26/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface CompanyRepo extends MongoRepository<Company,ObjectId> {

  Company findByName(String name);

}
