package com.thanos.soulgem.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thanos.soulgem.domain.authority.command.UserSignUp;
import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Create by zhangzheng on 8/3/18
 * Email:zhangzheng@youzan.com
 */
public class UserControllerTest extends BaseControllerTest {

  @Test
  public void testIllegalInput() throws Exception {
    UserSignUp userSignUp = new UserSignUp();
    userSignUp.setCompanyName("someCompany");
    userSignUp.setUsername("someUsername");
//    userSignUp.setPassword("xx");

    mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(toJson(userSignUp)))
        .andExpect(isResponseContainSomeContent("illegal_input"))
        .andExpect(status().isUnprocessableEntity());
  }


}
