package com.thanos.soulgem.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.common.collect.ImmutableList;
import com.thanos.soulgem.BaseIntegrationTestConfiguration;
import com.thanos.soulgem.domain.audit.AuditFlow;
import com.thanos.soulgem.domain.audit.AuditNode;
import com.thanos.soulgem.domain.squarepart.command.PlanSaveCommand;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 10/5/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseIntegrationTestConfiguration.class})
public class AuditFlowTest {
  @Autowired
  AuditFlowApp auditFlowApp;
  @Autowired
  PlanApp planApp;

  @Test
  public void testBasicAuditFlow(){
    String user1 = "user1";
    String user2 = "user2";
    AuditNode node1 = new AuditNode("",ImmutableList.of(user1));
    AuditNode node2 = new AuditNode("",ImmutableList.of(user2));
    //创建备件计划
    PlanSaveCommand planSaveCommand = new PlanSaveCommand();
    planSaveCommand.setAuditNodes(ImmutableList.of(node1, node2));
    planApp.save(planSaveCommand);
    //验证审批流
    //因为审批流是user1 -> user2, 所以此时user1会有一条审批流
    List<AuditFlow> auditFlows = auditFlowApp.findMyAuditFlow(user1);
    assertNotNull(auditFlows);
    assertEquals(1, auditFlows.size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user2).size());
    AuditFlow auditFlow = auditFlows.get(0);

    //user1 审核
    auditFlowApp.audit(auditFlow.id(), true, "comment", user1);
    assertEquals(0, auditFlowApp.findMyAuditFlow(user1).size());
    assertEquals(1, auditFlowApp.findMyAuditFlow(user2).size());
    auditFlow = auditFlowApp.findMyAuditFlow(user2).get(0);

    //user2 审核
    auditFlowApp.audit(auditFlow.id(), true, "comment", user2);
    assertEquals(0, auditFlowApp.findMyAuditFlow(user1).size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user2).size());

    //验证审批流的结果
    auditFlow = auditFlowApp.detail(auditFlow.id());
    assertEquals(true, auditFlow.finished());
  }

  @Test
  public void testAuditFlowWithMultiUser(){
    String user1 = "user1";
    String user2 = "user2";
    String user3 = "user3";
    AuditNode node1 = new AuditNode("",ImmutableList.of(user1));
    AuditNode node2 = new AuditNode("",ImmutableList.of(user2, user3));
    //创建备件计划
    PlanSaveCommand planSaveCommand = new PlanSaveCommand();
    planSaveCommand.setAuditNodes(ImmutableList.of(node1, node2));
    planApp.save(planSaveCommand);
    //验证审批流
    //因为审批流是user1 -> user2, 所以此时user1会有一条审批流
    List<AuditFlow> auditFlows = auditFlowApp.findMyAuditFlow(user1);
    assertNotNull(auditFlows);
    assertEquals(1, auditFlows.size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user2).size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user3).size());
    AuditFlow auditFlow = auditFlows.get(0);

    //user1 审核
    auditFlowApp.audit(auditFlow.id(), true, "comment", user1);
    assertEquals(0, auditFlowApp.findMyAuditFlow(user1).size());
    assertEquals(1, auditFlowApp.findMyAuditFlow(user2).size());
    assertEquals(1, auditFlowApp.findMyAuditFlow(user3).size());
    auditFlow = auditFlowApp.findMyAuditFlow(user2).get(0);

    //user2 审核
    auditFlowApp.audit(auditFlow.id(), true, "comment", user2);
    assertEquals(0, auditFlowApp.findMyAuditFlow(user1).size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user2).size());
    assertEquals(0, auditFlowApp.findMyAuditFlow(user3).size());

    //验证审批流的结果
    auditFlow = auditFlowApp.detail(auditFlow.id());
    assertEquals(true, auditFlow.finished());
  }


}
