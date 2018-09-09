package com.thanos.spacegem.model;

import lombok.Getter;

/**
 *
 * @author qiliang
 * @date 2018/8/25
 */
public enum CollectionPoint {


  REFUELING_POINT(0, "加油点"),
  DI_POINT(1, "DI点"),
  AI_POINT(2, "AI点"),
  CONDITION_POINT(3, "状态点"),
  ;

  @Getter
  int code;

  @Getter
  String  desc;

  CollectionPoint(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static CollectionPoint getCollectionPoint(int code){
    for (CollectionPoint collectionPoint : CollectionPoint.values()){
      if (collectionPoint.code == code){
        return collectionPoint;
      }
    }
    return null;
  }
}
