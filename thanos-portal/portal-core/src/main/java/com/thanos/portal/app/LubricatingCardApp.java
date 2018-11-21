package com.thanos.portal.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.portal.domain.basic.EquipmentRepo;
import com.thanos.portal.domain.basic.LubricatingCard;
import com.thanos.portal.domain.basic.LubricatingCardRepo;
import com.thanos.portal.domain.basic.command.LubricatingCardSave;
import com.thanos.portal.domain.basic.command.LubricatingCardUpdate;
import com.thanos.portal.domain.identity.PermissionGroup;
import com.thanos.portal.domain.identity.PermissionPoint;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create by zhangzheng on 8/25/18
 * Email:zhangzheng@youzan.com
 */
@Service
public class LubricatingCardApp {

  @Autowired
  EquipmentRepo equipmentRepo;
  @Autowired
  LubricatingCardRepo lubricatingCardRepo;

  @PermissionPoint(name = "新增润滑卡片", group = PermissionGroup.Equipment)
  public void save(LubricatingCardSave lubricatingCardSave){
    check(equipmentRepo.existsById(lubricatingCardSave.getEquipmentId()), "equipmentId not exist");
    LubricatingCard lubricatingCard = lubricatingCardSave.build();
    lubricatingCardRepo.save(lubricatingCard);
  }

  @PermissionPoint(name = "更新润滑卡片", group = PermissionGroup.Equipment)
  public void update(ObjectId id, LubricatingCardUpdate update){
    check(lubricatingCardRepo.existsById(id), "id not exist");
    LubricatingCard lubricatingCard = lubricatingCardRepo.findById(id).get();
    lubricatingCard.merge(update);
    lubricatingCardRepo.save(lubricatingCard);
  }

  @PermissionPoint(name = "删除润滑卡片", group = PermissionGroup.Equipment)
  public void delete(ObjectId id){
    check(lubricatingCardRepo.existsById(id), "id not exist");
    lubricatingCardRepo.deleteById(id);
  }

  public LubricatingCard detail(ObjectId id){
    check(lubricatingCardRepo.existsById(id), "id not exist");
    return lubricatingCardRepo.findById(id).get();
  }

  /**
   * 查询某个设备的润滑卡片
   * @param equipmentId
   * @param pageable
   * @return
   */
  public Page<LubricatingCard> listByEquipmentId(ObjectId equipmentId, Pageable pageable){
    return lubricatingCardRepo.findAllByEquipmentId(equipmentId,pageable);
  }



}
