package com.dm.thanos.repository;

import com.dm.thanos.AbstractIntegrationTest;
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
