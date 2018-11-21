package com.thanos.portal.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thanos.portal.domain.identity.Company;
import com.thanos.portal.domain.identity.CompanyRepo;
import com.thanos.portal.domain.identity.User;
import com.thanos.portal.domain.identity.UserRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer;

/**
 * Create by zhangzheng on 8/31/18
 * Email:zhangzheng@youzan.com
 */
@ActiveProfiles("auth")
public class UserLoginTest extends BaseControllerTest{
  @Autowired
  FilterRegistrationBean filterRegistrationBean;
  @Autowired
  UserRepo userRepo;
  @Autowired
  CompanyRepo companyRepo;

  @Test
  public void testAccessDeniedWhenNotLogin() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .addFilter(filterRegistrationBean.getFilter(), "/*")
        .build();

    mockMvc.perform(get("/equipments"))
        .andDo(print())
        .andExpect(isResponseContainSomeContent("user not login"))
        .andExpect(status().isForbidden());

    mockMvc.perform(post("/login")
        .content("{\"username\":\"\",\"password\":\"\"}").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(isResponseContainSomeContent("illegal_input"));

  }


  private String someUsername = "someUsername";
  @Test
  public void testAccessAllowWhenLogin() throws Exception {
    initializeUser();
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .addFilter(filterRegistrationBean.getFilter(), "/*")
        .apply(SharedHttpSessionConfigurer.sharedHttpSession())
        .build();

    String content = "{\"username\":\""+someUsername+"\",\"password\":\""+User.defaultPassword()+"\"}";
    mockMvc.perform(post("/login").content(content)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andExpect(isResponseContainSomeContent(someUsername));

    mockMvc.perform(get("/equipments"))
        .andDo(print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(isResponseContainSomeContent("pageSize"));

    clearUser();
  }

  private void initializeUser(){
    Company someCompany = new Company("someCompany",null,null);
    companyRepo.save(someCompany);
    User user = new User(someCompany,someUsername,"someRealName", null,null);
    userRepo.save(user);
  }

  private void clearUser(){
    companyRepo.deleteAll();
    userRepo.deleteAll();
  }


}
