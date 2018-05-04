package com.hl.kingkong.repository;

import static org.junit.Assert.*;

import com.hl.kingkong.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by zhangzheng on 5/2/18
 */
public class EquipmentRepositoryTest extends AbstractIntegrationTest {

  @Autowired
  EquipmentRepository equipmentRepository;

  @Test
  public void test(){
    equipmentRepository.findAll();
  }


}
