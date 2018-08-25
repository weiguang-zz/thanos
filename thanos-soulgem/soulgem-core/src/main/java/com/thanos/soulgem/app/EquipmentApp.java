package com.thanos.soulgem.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.soulgem.domain.basic.Equipment;
import com.thanos.soulgem.domain.basic.EquipmentCategoryRepo;
import com.thanos.soulgem.domain.basic.EquipmentRepo;
import com.thanos.soulgem.domain.basic.LubricatingCardRepo;
import com.thanos.soulgem.domain.basic.SquarePartRepo;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateEquipment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class EquipmentApp {
  @Autowired
  EquipmentRepo equipmentRepo;
  @Autowired
  SquarePartRepo squarePartRepo;
  @Autowired
  LubricatingCardRepo lubricatingCardRepo;
  @Autowired
  EquipmentCategoryRepo equipmentCategoryRepo;

  /**
   * 新增或者修改设备，跟repo的save方法统一
   * @param saveOrUpdateEquipment
   */
  public void save(SaveOrUpdateEquipment saveOrUpdateEquipment){
    saveOrUpdateEquipment.setCategory(equipmentCategoryRepo.findOne(saveOrUpdateEquipment.getCategoryId()));
    Equipment equipment = saveOrUpdateEquipment.build();
    equipmentRepo.save(equipment);
  }

  public void update(ObjectId id, SaveOrUpdateEquipment saveOrUpdateEquipment){
    check(equipmentRepo.exists(id), "id not exists");
    Equipment equipment = equipmentRepo.findOne(id);
    equipment.merge(saveOrUpdateEquipment);
    equipmentRepo.save(equipment);
  }

  /**
   * 删除设备
   * @param id
   */
  public void delete(ObjectId id){
    check(equipmentRepo.exists(id), "id not exists");
    equipmentRepo.delete(id);
    squarePartRepo.deleteAllByEquipmentId(id);
    lubricatingCardRepo.deleteAllByEquipmentId(id);
  }

  public Equipment detail(ObjectId id){
    check(equipmentRepo.exists(id), "id not exists");
    return equipmentRepo.findOne(id);
  }

  public Page<Equipment> list(Pageable pageable){
    return equipmentRepo.findAll(pageable);
  }

}
