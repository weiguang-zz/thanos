package com.thanos.soulgem.domain.authority;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
public interface UserRepo extends PagingAndSortingRepository<User, ObjectId>{

  List<User> findByUsername(String username);

}
