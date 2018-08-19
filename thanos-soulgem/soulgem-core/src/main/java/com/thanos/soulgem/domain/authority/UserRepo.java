package com.thanos.soulgem.domain.authority;

import java.util.List;
import javax.jws.soap.SOAPBinding.Use;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {

  public User findByUsernameAndCompany(String username, ObjectId companyId);

}
