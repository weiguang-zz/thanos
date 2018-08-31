package com.thanos.soulgem.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.soulgem.domain.basic.EquipmentRepo;
import com.thanos.soulgem.domain.basic.SquarePart;
import com.thanos.soulgem.domain.basic.SquarePartRepo;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateSquarePart;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/25/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class SquarePartApp {

  @Autowired
  EquipmentRepo equipmentRepo;
  @Autowired
  SquarePartRepo squarePartRepo;


  public void save(SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    check(equipmentRepo.existsById(saveOrUpdateSquarePart.getEquipmentId()), "equipmentId not exist");
    SquarePart squarePart = saveOrUpdateSquarePart.build();
    squarePartRepo.save(squarePart);
  }

  public void update(ObjectId id, SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    check(squarePartRepo.existsById(id), "id not exist");
    SquarePart squarePart = squarePartRepo.findById(id).get();
    BeanUtils.copyProperties(saveOrUpdateSquarePart, squarePart);
    squarePartRepo.save(squarePart);
  }

  public void delete(ObjectId id){
    check(squarePartRepo.existsById(id), "id not exist");
    squarePartRepo.deleteById(id);
  }

  public void deleteAllInEquipment(ObjectId equipmentId){
    squarePartRepo.deleteAllByEquipmentId(equipmentId);
  }

  public Page<SquarePart> listAllInEquipment(ObjectId equipmentId, Pageable pageable){
    return squarePartRepo.findAllByEquipmentId(equipmentId, pageable);
  }




}
