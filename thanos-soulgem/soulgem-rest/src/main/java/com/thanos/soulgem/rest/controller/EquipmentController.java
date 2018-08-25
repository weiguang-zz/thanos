package com.thanos.soulgem.rest.controller;

import static com.thanos.soulgem.rest.check.InputAssert.check;
import static com.thanos.soulgem.rest.check.InputAssert.notNull;

import com.thanos.soulgem.app.EquipmentApp;
import com.thanos.soulgem.app.LubricatingCardApp;
import com.thanos.soulgem.app.SquarePartApp;
import com.thanos.soulgem.domain.basic.Equipment;
import com.thanos.soulgem.domain.basic.LubricatingCard;
import com.thanos.soulgem.domain.basic.SquarePart;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateEquipment;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateLubricatingCard;
import com.thanos.soulgem.domain.basic.command.SaveOrUpdateSquarePart;
import com.thanos.soulgem.rest.dto.Page;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Create by zhangzheng on 8/19/18
 * Email:zhangzheng@youzan.com
 */
@RestController
@RequestMapping("equipments")
public class EquipmentController {

  @Autowired
  EquipmentApp equipmentApp;
  @Autowired
  SquarePartApp squarePartApp;
  @Autowired
  LubricatingCardApp lubricatingCardApp;

  @PostMapping
  public void save(@RequestBody SaveOrUpdateEquipment saveOrUpdateEquipment){
    saveOrUpdateEquipment.validate();
    equipmentApp.save(saveOrUpdateEquipment);
  }
  @PutMapping("/{id}")
  public void update(@PathVariable("id")ObjectId id, SaveOrUpdateEquipment saveOrUpdateEquipment){
    saveOrUpdateEquipment.validate();
    check(id!=null, "id is null");
    equipmentApp.update(id, saveOrUpdateEquipment);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id")ObjectId id){
    check(id!=null, "id is null");
    equipmentApp.delete(id);
  }
  @GetMapping("/{id}")
  public Equipment detail(@PathVariable("id")ObjectId id){
    check(id!=null, "id is null");
    return equipmentApp.detail(id);
  }
  @GetMapping
  public Page<Equipment> list(@PageableDefault Pageable pageable){
    return Page.of(equipmentApp.list(pageable));
  }

  @PostMapping("/{id}/squartParts")
  public void saveSquarePart(@PathVariable("id") ObjectId id, @RequestBody SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    check(id!=null, "equipment id must not be null");
    saveOrUpdateSquarePart.setEquipmentId(id);
    saveOrUpdateSquarePart.validate();
    squarePartApp.save(saveOrUpdateSquarePart);
  }
  @PutMapping("/{eid}/squareParts/{sid}")
  public void updateSquarePart(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("sid")ObjectId squarePartId,
      @RequestBody SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    saveOrUpdateSquarePart.setEquipmentId(equipmentId);
    squarePartApp.update(squarePartId, saveOrUpdateSquarePart);
  }
  @DeleteMapping("/{eid}/squareParts/{sid}")
  public void deleteSquarePart(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("sid")ObjectId squarePartId){
    squarePartApp.delete(squarePartId);
  }
  @GetMapping("/{id}/squartParts")
  public Page<SquarePart> squareParts(@PathVariable("id")ObjectId equipmentId, @PageableDefault Pageable pageable){
    notNull(equipmentId,"equipmentId");
    return Page.of(squarePartApp.listAllInEquipment(equipmentId, pageable));
  }

  @PostMapping("/{id}/lubricatingCards")
  public void saveLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @RequestBody SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard){
    notNull(equipmentId, "equipmentId");
    saveOrUpdateLubricatingCard.setEquipmentId(equipmentId);
    lubricatingCardApp.save(saveOrUpdateLubricatingCard);
  }
  @DeleteMapping("/{eid}/lubricatingCards/{lid}")
  public void deleteLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("lid")ObjectId lubricatingCardId){
    notNull(equipmentId,"equipmentId");
    notNull(lubricatingCardId, "lubricatingCardId");
    lubricatingCardApp.delete(lubricatingCardId);
  }
  @PutMapping("/{eid}/lubricatingCards/{lid}")
  public void updateLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("lid")ObjectId lubricatingCardId,
      @RequestBody SaveOrUpdateLubricatingCard saveOrUpdateLubricatingCard){
    notNull(lubricatingCardId, "lubricatingCardId");
    notNull(equipmentId, "equipmentId");
    saveOrUpdateLubricatingCard.setEquipmentId(equipmentId);
    lubricatingCardApp.update(lubricatingCardId, saveOrUpdateLubricatingCard);
  }
  @GetMapping("/{id}/lubricatingCards")
  public Page<LubricatingCard> lubricatingCards(@PathVariable("id")ObjectId equipmentId,
      @PageableDefault Pageable pageable){
    notNull(equipmentId, "equipmentId");
    return Page.of(lubricatingCardApp.listByEquipmentId(equipmentId, pageable));
  }




}
