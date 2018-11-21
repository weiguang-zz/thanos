package com.thanos.portal.domain.identity;

/**
 * Create by zhangzheng on 8/30/18
 * Email:zhangzheng@youzan.com
 * 该接口可由rest层来实现，存储登陆了的用户
 *
 */
public interface UserHolder {

  User getUser();

}
