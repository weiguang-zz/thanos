//package com.thanos.common.domain;
//
//import com.mongodb.DBObject;
//import java.util.Date;
//import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
//import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
//import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
//import org.springframework.stereotype.Component;
//
///**
// * Create by zhangzheng on 7/20/18
// * Email:zhangzheng@youzan.com
// */
//@Component
//public class DateRecordAdvice extends AbstractMongoEventListener{
//
//  private static String CREATED_AT = "createdAt";
//  private static String UPDATED_AT = "updatedAt";
//
//  @Override
//  public void onBeforeSave(BeforeSaveEvent event) {
//    DBObject dbObject = event.getDBObject();
//    if(!dbObject.containsField(CREATED_AT)){
//      dbObject.put(CREATED_AT, new Date());
//    }
//    dbObject.put(UPDATED_AT, new Date());
//    super.onBeforeSave(event);
//  }
//
//
//  @Override
//  public void onBeforeDelete(BeforeDeleteEvent event) {
//    DBObject dbObject = event.getDBObject();
//    dbObject.put(UPDATED_AT, new Date());
//    super.onBeforeDelete(event);
//  }
//
//}
