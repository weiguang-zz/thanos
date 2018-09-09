package com.thanos.soulgem.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thanos.soulgem.domain.identity.command.UserSave;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Create by zhangzheng on 8/3/18
 * Email:zhangzheng@youzan.com
 */
public class UserControllerTest extends BaseControllerTest {

  @Test
  public void testIllegalInput() throws Exception {
    UserSave userSave = new UserSave();
    userSave.setCompanyId(new ObjectId("5b52d1d7aa73821baf1f23cb"));
    userSave.setUsername("some");

    mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(toJson(userSave)))
        .andExpect(isResponseContainSomeContent("illegal_input"))
        .andExpect(status().isUnprocessableEntity());
  }


}
