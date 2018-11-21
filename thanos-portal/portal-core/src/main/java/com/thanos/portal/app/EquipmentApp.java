package com.thanos.portal.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.portal.domain.basic.Equipment;
import com.thanos.portal.domain.basic.EquipmentCategory;
import com.thanos.portal.domain.basic.EquipmentCategoryRepo;
import com.thanos.portal.domain.basic.EquipmentRepo;
import com.thanos.portal.domain.basic.LubricatingCardRepo;
import com.thanos.portal.domain.basic.SquarePartRepo;
import com.thanos.portal.domain.basic.command.EquipmentSave;
import com.thanos.portal.domain.basic.command.EquipmentUpdate;
import com.thanos.portal.domain.identity.PermissionGroup;
import com.thanos.portal.domain.identity.PermissionPoint;
import java.util.List;
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
   * 新增设备
   */
  @PermissionPoint(name = "新增设备", group = PermissionGroup.Equipment)
  public Equipment save(EquipmentSave equipmentSave){
    Equipment equipment = equipmentSave.build();
    return equipmentRepo.save(equipment);
  }

  @PermissionPoint(name = "更新设备", group = PermissionGroup.Equipment)
  public void update(ObjectId id, EquipmentUpdate equipmentUpdate){
    check(equipmentRepo.existsById(id), "id not exists");
    Equipment equipment = equipmentRepo.findById(id).get();
    equipment.merge(equipmentUpdate);
    equipmentRepo.save(equipment);
  }

  /**
   * 删除设备
   * @param id
   */
  @PermissionPoint(name = "删除设备", group = PermissionGroup.Equipment)
  public void delete(ObjectId id){
    check(equipmentRepo.existsById(id), "id not exists");
    equipmentRepo.deleteById(id);
    squarePartRepo.deleteAllByEquipmentId(id);
    lubricatingCardRepo.deleteAllByEquipmentId(id);
  }

  public Equipment detail(ObjectId id){
    check(equipmentRepo.existsById(id), "id not exists");
    return equipmentRepo.findById(id).get();
  }

  public Page<Equipment> list(Pageable pageable){
    return equipmentRepo.findAll(pageable);
  }

  public List<EquipmentCategory> categories(){
    return equipmentCategoryRepo.findAll();
  }

}
