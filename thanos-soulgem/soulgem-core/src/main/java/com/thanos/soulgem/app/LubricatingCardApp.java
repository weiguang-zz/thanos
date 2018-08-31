package com.thanos.soulgem.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.soulgem.domain.basic.EquipmentRepo;
import com.thanos.soulgem.domain.basic.LubricatingCard;
import com.thanos.soulgem.domain.basic.LubricatingCardRepo;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateLubricatingCard;
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


  public void save(SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard){

    check(equipmentRepo.existsById(saveOrUpdateLubricatingCard.getEquipmentId()), "equipmentId not exist");
    LubricatingCard lubricatingCard = saveOrUpdateLubricatingCard.build();
    lubricatingCardRepo.save(lubricatingCard);
  }

  public void update(ObjectId id, SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard){
    check(lubricatingCardRepo.existsById(id), "id not exist");
    LubricatingCard lubricatingCard = lubricatingCardRepo.findById(id).get();
    lubricatingCard.merge(saveOrUpdateLubricatingCard);
    lubricatingCardRepo.save(lubricatingCard);
  }

  public void delete(ObjectId id){
    check(lubricatingCardRepo.existsById(id), "id not exist");
    lubricatingCardRepo.deleteById(id);
  }

  /**
   * 删除某个设备下所有的润滑卡片
   * @param equipmentId
   */
  public void deleteAllOfEquipment(ObjectId equipmentId){
    lubricatingCardRepo.deleteAllByEquipmentId(equipmentId);
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
