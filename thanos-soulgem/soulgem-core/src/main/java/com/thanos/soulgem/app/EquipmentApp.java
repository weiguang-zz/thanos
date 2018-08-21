package com.thanos.soulgem.app;

import com.thanos.soulgem.domain.core.Equipment;
import com.thanos.soulgem.domain.core.EquipmentRepo;
import com.thanos.soulgem.domain.core.LubricatingCard;
import com.thanos.soulgem.domain.core.LubricatingCardRepo;
import com.thanos.soulgem.domain.core.SquarePart;
import com.thanos.soulgem.domain.core.SquarePartRepo;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateEquipment;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateLubricatingCard;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateSquarePart;
import static com.thanos.common.domain.exception.BizAssert.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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

  /**
   * 新增或者修改设备，跟repo的save方法统一
   * @param saveOrUpdateEquipment
   */
  public void saveOrUpdate(SaveOrUpdateEquipment saveOrUpdateEquipment){
    Equipment equipment = new Equipment(saveOrUpdateEquipment);
    if(saveOrUpdateEquipment.getId()!=null){
      check(equipmentRepo.exists(saveOrUpdateEquipment.getId()),"id not exist");
    }
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


  /**
   * 新增或者修改备件
   * @param saveOrUpdateSquarePart
   */
  public void saveOrUpdateSquarePart(SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    check(equipmentRepo.exists(saveOrUpdateSquarePart.getEquipmentId()), "equipmentId not exist");
    if(saveOrUpdateSquarePart.getId()!=null){
      check(squarePartRepo.exists(saveOrUpdateSquarePart.getId()),
          "id not exist");
    }
    SquarePart squarePart = new SquarePart(saveOrUpdateSquarePart);
    squarePartRepo.save(squarePart);
  }

  public void deleteSquarePart(ObjectId id){
    check(squarePartRepo.exists(id), "id not exist");
    squarePartRepo.delete(id);
  }

  public void saveOrUpdateLubricatingCard(SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard){
    check(equipmentRepo.exists(saveOrUpdateLubricatingCard.getEquipmentId()), "equipmentId not exist");
    if(saveOrUpdateLubricatingCard.getId()!=null){
      check(lubricatingCardRepo.exists(saveOrUpdateLubricatingCard.getId()),
          "id not exist");
    }
    LubricatingCard lubricatingCard = new LubricatingCard(saveOrUpdateLubricatingCard);
    lubricatingCardRepo.save(lubricatingCard);
  }

  public void deleteLubricatingCard(ObjectId id){
    check(lubricatingCardRepo.exists(id), "id not exist");
    lubricatingCardRepo.delete(id);
  }


}
