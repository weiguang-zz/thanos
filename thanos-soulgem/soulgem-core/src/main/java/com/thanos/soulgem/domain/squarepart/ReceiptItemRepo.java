package com.thanos.soulgem.domain.squarepart;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface ReceiptItemRepo extends MongoRepository<ReceiptItem,ObjectId> {

}
