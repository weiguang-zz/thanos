package com.thanos.soulgem.rest.controller;

import com.thanos.soulgem.app.EquipmentApp;
import com.thanos.soulgem.domain.core.command.SaveOrUpdateEquipment;
import static com.thanos.soulgem.rest.check.InputAssert.*;

import com.thanos.soulgem.domain.core.command.SaveOrUpdateSquarePart;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping
  public void save(@RequestBody SaveOrUpdateEquipment saveOrUpdateEquipment){
    saveOrUpdateEquipment.validate();
    equipmentApp.saveOrUpdate(saveOrUpdateEquipment);
  }


  @PostMapping("/{id}/squartParts")
  public void saveSquarePart(@PathVariable("id") ObjectId id, @RequestBody SaveOrUpdateSquarePart saveOrUpdateSquarePart){
    check(id!=null, "equipment id must not be null");
    saveOrUpdateSquarePart.setEquipmentId(id);
    saveOrUpdateSquarePart.validate();
    equipmentApp.saveOrUpdateSquarePart(saveOrUpdateSquarePart);
  }


}
