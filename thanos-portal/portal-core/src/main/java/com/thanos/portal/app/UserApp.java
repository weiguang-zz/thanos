package com.thanos.portal.app;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

import com.thanos.common.domain.exception.BizAssert;
import com.thanos.portal.domain.identity.Company;
import com.thanos.portal.domain.identity.CompanyRepo;
import com.thanos.portal.domain.identity.DepartmentRepo;
import com.thanos.portal.domain.identity.PermissionGroup;
import com.thanos.portal.domain.identity.PermissionPoint;
import com.thanos.portal.domain.identity.Role;
import com.thanos.portal.domain.identity.RoleRepo;
import com.thanos.portal.domain.identity.User;
import com.thanos.portal.domain.identity.UserHolder;
import com.thanos.portal.domain.identity.UserRepo;
import com.thanos.portal.domain.identity.command.UserSave;
import com.thanos.portal.domain.identity.command.UserUpdate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 7/20/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class UserApp {
  @Resource
  UserRepo userRepo;

  @Resource
  CompanyRepo companyRepo;
  @Resource
  RoleRepo roleRepo;
  @Resource
  DepartmentRepo departmentRepo;

  @Autowired(required = false)
  UserHolder userHolder;

  @PermissionPoint(name = "新增用户", group = PermissionGroup.System)
  public void save(UserSave userSave){
    Company company = companyRepo.findById(userSave.getCompanyId()).get();
    BizAssert.check(company!=null, "company不存在");
    checkUserNameNotExist(userSave.getUsername());
    User user = new User(company, userSave.getUsername(), userSave.getRealname()
        , userSave.getMobile(), userHolder.getUser().realname());
    for(ObjectId roleId: userSave.getRoleIds()){
      user.assinRole(roleRepo.findById(roleId).get());
    }
    if(userSave.getDepartmentId()!=null){
      user.assginDepartment(departmentRepo.findById(userSave.getDepartmentId()).get());
    }
    userRepo.save(user);
  }

  @PermissionPoint(name = "修改用户",group = PermissionGroup.System)
  public void update(ObjectId id, UserUpdate userUpdate){
    BizAssert.check(userRepo.existsById(id), "user id not exist");
    User user = userRepo.findById(id).get();
    user.merge(userUpdate);
    if(userUpdate.getDepartmentId()!=null){
      user.assginDepartment(departmentRepo.findById(userUpdate.getDepartmentId()).get());
    }
    List<Role> roles = Collections.emptyList();
    for(ObjectId roleId:userUpdate.getRoleIds()){
      roles.add(roleRepo.findById(roleId).get());
    }
    user.assinAllRole(roles);
    userRepo.save(user);
  }

  @PermissionPoint(name = "删除用户", group = PermissionGroup.System)
  public void delete(ObjectId id){
    BizAssert.check(userRepo.existsById(id), "user id not exist");
    userRepo.deleteById(id);
  }

  public User detail(ObjectId id){
    return userRepo.findById(id).get();
  }

  public Page<User> list(Pageable pageable){
    return  userRepo.findAll(pageable);
  }

  //根据用户名或者真实名查询
  public Page<User> queryByUsernameOrRealname(String keyword, Pageable pageable){
    Example<User> example = Example.of(
        new User(null, keyword,keyword,null, null),
        ExampleMatcher.matchingAny()
            .withIgnorePaths("password","passwordChanged","createdAt","roles","company","department")
            .withMatcher("username", contains())
            .withMatcher("realname",contains()));
    return userRepo.findAll(example, pageable);
  }



  private void checkUserNameNotExist(String username){
    User user = userRepo.findByUsername(username);
    BizAssert.check(user==null, "username:%s exists", username);
  }

  public User login(String username, String password){
    User user = userRepo.findByUsername(username);
    BizAssert.check(user!=null, "username:%s not exists", username);
    BizAssert.check(password.equals(user.password()), "wrong password");
    return user;
  }

}
