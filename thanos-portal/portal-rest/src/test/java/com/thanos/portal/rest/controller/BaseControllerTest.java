package com.thanos.portal.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.thanos.portal.rest.SoulgemApplication;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Create by zhangzheng on 8/1/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SoulgemApplication.class)
@Ignore
public class BaseControllerTest {
  @Autowired
  protected WebApplicationContext webApplicationContext;
  @Autowired
  ObjectMapper objectMapper;

  protected MockMvc mockMvc;
  protected Gson gson = new Gson();

  @Before
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  protected ResultMatcher isResponseContainSomeContent(String content){
    return content().string(CoreMatchers.containsString(content));
  }

  protected String toJson(Object data){
    try {
      return objectMapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("",e);
    }
  }


}
