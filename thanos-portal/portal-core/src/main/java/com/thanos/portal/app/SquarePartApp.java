package com.thanos.portal.app;

import static com.thanos.common.domain.exception.BizAssert.check;

import com.thanos.common.utils.BeanUtils;
import com.thanos.portal.domain.basic.EquipmentRepo;
import com.thanos.portal.domain.basic.SquarePart;
import com.thanos.portal.domain.basic.SquarePartRepo;
import com.thanos.portal.domain.basic.command.SquarePartSave;
import com.thanos.portal.domain.basic.command.SquarePartUpdate;
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
public class SquarePartApp {

  @Autowired
  EquipmentRepo equipmentRepo;
  @Autowired
  SquarePartRepo squarePartRepo;

  @PermissionPoint(name = "新增备件目录", group = PermissionGroup.Equipment)
  public void save(SquarePartSave save){
    check(equipmentRepo.existsById(save.getEquipmentId()), "equipmentId not exist");
    SquarePart squarePart = save.build();
    squarePartRepo.save(squarePart);
  }
  @PermissionPoint(name = "更新备件目录", group = PermissionGroup.Equipment)
  public void update(ObjectId id, SquarePartUpdate update){
    check(squarePartRepo.existsById(id), "id not exist");
    SquarePart squarePart = squarePartRepo.findById(id).get();
    BeanUtils.copyProperties(update, squarePart);
    squarePartRepo.save(squarePart);
  }
  @PermissionPoint(name = "删除备件目录", group = PermissionGroup.Equipment)
  public void delete(ObjectId id){
    check(squarePartRepo.existsById(id), "id not exist");
    squarePartRepo.deleteById(id);
  }

  public Page<SquarePart> listAllInEquipment(ObjectId equipmentId, Pageable pageable){
    return squarePartRepo.findAllByEquipmentId(equipmentId, pageable);
  }


}
