package com.thanos.portal.app;

import com.thanos.common.utils.BeanUtils;
import com.thanos.portal.domain.basic.Process;
import com.thanos.portal.domain.basic.ProductionLine;
import com.thanos.portal.domain.basic.ProductionLineRepo;
import com.thanos.portal.domain.basic.command.ProductionLineSave;
import com.thanos.portal.domain.basic.command.ProductionLineUpdate;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 11/17/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class ProductionLineApp {
  @Autowired
  ProductionLineRepo productionLineRepo;

  public List<ProductionLine> list(){
    return productionLineRepo.findAll();
  }

  public List<Process> processes(ObjectId id){
    return productionLineRepo.findById(id).get().processes();
  }

  public void save(ProductionLineSave save){
    ProductionLine toSave = BeanUtils.transfer(save, ProductionLine.class);
    productionLineRepo.save(toSave);
  }

  public void update(ProductionLineUpdate update){
    ProductionLine toUpdate = BeanUtils.transfer(update, ProductionLine.class);
    productionLineRepo.save(toUpdate);
  }

}
