package com.thanos.soulgem.rest.controller;

import static com.thanos.soulgem.rest.check.InputAssert.check;
import static com.thanos.soulgem.rest.check.InputAssert.notNull;

import com.thanos.soulgem.app.EquipmentApp;
import com.thanos.soulgem.app.LubricatingCardApp;
import com.thanos.soulgem.app.SquarePartApp;
import com.thanos.soulgem.domain.basic.Equipment;
import com.thanos.soulgem.domain.basic.LubricatingCard;
import com.thanos.soulgem.domain.basic.SquarePart;
import com.thanos.soulgem.domain.basic.command.EquipmentSave;
import com.thanos.soulgem.domain.basic.command.EquipmentUpdate;
import com.thanos.soulgem.domain.basic.command.LubricatingCardSave;
import com.thanos.soulgem.domain.basic.command.LubricatingCardUpdate;
import com.thanos.soulgem.domain.basic.command.SquarePartSave;
import com.thanos.soulgem.domain.basic.command.SquarePartUpdate;
import com.thanos.soulgem.rest.check.InputAssert;
import com.thanos.soulgem.rest.dto.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/equipments")
public class EquipmentController {

  @Autowired
  EquipmentApp equipmentApp;
  @Autowired
  SquarePartApp squarePartApp;
  @Autowired
  LubricatingCardApp lubricatingCardApp;

  @PostMapping
  @ApiOperation(value = "新增设备")
  public Equipment save(@RequestBody EquipmentSave save){
    save.validate();
    return equipmentApp.save(save);
  }
  @PutMapping("/{id}")
  @ApiOperation(value = "更新设备")
  public void update(@ApiParam(type = "string") @PathVariable("id")ObjectId id,
      @RequestBody EquipmentUpdate update){
    update.validate();
    InputAssert.notNull(id, "id");
    equipmentApp.update(id, update);
  }
  @DeleteMapping("/{id}")
  @ApiOperation(value = "删除设备")
  public void delete(@PathVariable("id")ObjectId id){
    check(id!=null, "id is null");
    equipmentApp.delete(id);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "查询设备详情")
  public Equipment detail(@PathVariable("id")ObjectId id){
    check(id!=null, "id is null");
    return equipmentApp.detail(id);
  }

  @GetMapping
  @ApiOperation(value = "设备列表")
  public Page<Equipment> list(@PageableDefault Pageable pageable){
    return Page.of(equipmentApp.list(pageable));
  }

  @PostMapping("/{id}/squareParts")
  @ApiOperation(value = "新增设备下的备件")
  public void saveSquarePart(@PathVariable("id") ObjectId id, @RequestBody SquarePartSave save){
    check(id!=null, "equipment id must not be null");
    save.setEquipmentId(id);
    save.validate();
    squarePartApp.save(save);
  }

  @PutMapping("/{eid}/squareParts/{sid}")
  @ApiOperation(value = "修改设备下的某个备件")
  public void updateSquarePart(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("sid")ObjectId squarePartId,
      @RequestBody SquarePartUpdate update){
    update.setEquipmentId(equipmentId);
    squarePartApp.update(squarePartId, update);
  }
  @DeleteMapping("/{eid}/squareParts/{sid}")
  @ApiOperation(value = "删除设备下的备件")
  public void deleteSquarePart(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("sid")ObjectId squarePartId){
    squarePartApp.delete(squarePartId);
  }

  @GetMapping("/{id}/squareParts")
  @ApiOperation(value = "查询设备备件目录")
  public Page<SquarePart> squareParts(@PathVariable("id")ObjectId equipmentId, @PageableDefault Pageable pageable){
    notNull(equipmentId,"equipmentId");
    return Page.of(squarePartApp.listAllInEquipment(equipmentId, pageable));
  }

  @PostMapping("/{eid}/lubricatingCards")
  @ApiOperation(value = "新增润滑卡片")
  public void saveLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @RequestBody LubricatingCardSave lubricatingCardSave){
    notNull(equipmentId, "equipmentId");
    lubricatingCardSave.setEquipmentId(equipmentId);
    lubricatingCardApp.save(lubricatingCardSave);
  }

  @DeleteMapping("/{eid}/lubricatingCards/{lid}")
  @ApiOperation(value = "删除润滑卡片")
  public void deleteLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("lid")ObjectId lubricatingCardId){
    notNull(equipmentId,"equipmentId");
    notNull(lubricatingCardId, "lubricatingCardId");
    lubricatingCardApp.delete(lubricatingCardId);
  }

  @PutMapping("/{eid}/lubricatingCards/{lid}")
  @ApiOperation(value = "修改润滑卡片")
  public void updateLubricatingCard(@PathVariable("eid")ObjectId equipmentId,
      @PathVariable("lid")ObjectId lubricatingCardId,
      @RequestBody LubricatingCardUpdate lubricatingCardUpdate){
    notNull(lubricatingCardId, "lubricatingCardId");
    notNull(equipmentId, "equipmentId");
    lubricatingCardUpdate.setEquipmentId(equipmentId);
    lubricatingCardApp.update(lubricatingCardId, lubricatingCardUpdate);
  }

  @GetMapping("/{id}/lubricatingCards")
  @ApiOperation(value = "查询设备下的润滑卡片列表")
  public Page<LubricatingCard> lubricatingCards(@PathVariable("id")ObjectId equipmentId,
      @PageableDefault Pageable pageable){
    notNull(equipmentId, "equipmentId");
    return Page.of(lubricatingCardApp.listByEquipmentId(equipmentId, pageable));
  }




}
