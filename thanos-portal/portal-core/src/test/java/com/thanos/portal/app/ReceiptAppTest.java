package com.thanos.portal.app;

import com.google.common.collect.ImmutableList;
import com.thanos.portal.BaseIntegrationTestConfiguration;
import com.thanos.portal.domain.basic.SquarePart;
import com.thanos.portal.domain.basic.SquarePartRepo;
import com.thanos.portal.domain.squarepart.Receipt;
import com.thanos.portal.domain.squarepart.ReceiptItem;
import com.thanos.portal.domain.squarepart.ReceiptItemRepo;
import com.thanos.portal.domain.squarepart.ReceiptRepo;
import com.thanos.portal.domain.squarepart.SquarePartInstance;
import com.thanos.portal.domain.squarepart.SquarePartInstanceRepo;
import com.thanos.portal.domain.squarepart.SquarePartStock;
import com.thanos.portal.domain.squarepart.SquarePartStockRepo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by zhangzheng on 10/21/18
 * Email:zhangzheng@youzan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseIntegrationTestConfiguration.class})
public class ReceiptAppTest {
  @Autowired
  ReceiptApp receiptApp;
  @Autowired
  SquarePartStockRepo squarePartStockRepo;
  @Autowired
  SquarePartRepo squarePartRepo;
  @Autowired
  ReceiptRepo receiptRepo;
  @Autowired
  ReceiptItemRepo receiptItemRepo;
  @Autowired
  SquarePartInstanceRepo squarePartInstanceRepo;

  //如果创建验收单，则库存数量增加
  @Test
  public void testStockIncrWhenReceiptCreated(){
    //初始化库存
    SquarePart s1 = new SquarePart();
    SquarePart s2 = new SquarePart();
    squarePartRepo.saveAll(ImmutableList.of(s1, s2));
    SquarePartStock stock1 = new SquarePartStock(s1,1);
    SquarePartStock stock2 = new SquarePartStock(s2,1);
    squarePartStockRepo.save(stock1);
    squarePartStockRepo.save(stock2);
    //创建验收单
    SquarePartInstance squarePartInstance1 = new SquarePartInstance(s1);
    SquarePartInstance squarePartInstance2 = new SquarePartInstance(s2);
    squarePartInstanceRepo.saveAll(ImmutableList.of(squarePartInstance1, squarePartInstance2));
    ReceiptItem receiptItem1 = new ReceiptItem(squarePartInstance1,1);
    ReceiptItem receiptItem2 = new ReceiptItem(squarePartInstance2,2);
    receiptItemRepo.saveAll(ImmutableList.of(receiptItem1, receiptItem2));
    Receipt receipt = new Receipt(ImmutableList.of(receiptItem1, receiptItem2));
    receiptRepo.save(receipt);
    //验证库存
//    squarePartStockRepo.findBySquarePart_Id(s1.)




  }


  @After
  public void clear(){
    squarePartStockRepo.deleteAll();
  }

}
