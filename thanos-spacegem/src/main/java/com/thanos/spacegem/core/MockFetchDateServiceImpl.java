package com.thanos.spacegem.core;

import com.thanos.common.domain.RealTimeData;
import com.thanos.spacegem.model.CollectionPoint;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author qiliang
 * @date 2018/8/25
 */
@Slf4j
@Component("mockFetchDateService")
public class MockFetchDateServiceImpl implements FetchDataService {

  private static Random random = new Random();

  private static Random randomLong = new Random(100);

  /**
   * 加油点状态集合
   */
  private static List<Integer> refuelingPointState = Arrays.asList(0, 1);


  /**
   * DI点状态集合
   */
  private static List<Integer> diPointState = Arrays.asList(0, 1, 2, 3);

  /**
   * 状态点状态集合
   */
  private static List<String>
      conditionPointState =
      Arrays.asList("良好", "有报警", "正常", "1级报警", "2级报警", "3级报警", "4级报警");


  @Value("${companyId}")
  private String companyId;

  private Map<String, Integer> collectPointMap = new HashMap<>();


  @Override
  public List<RealTimeData> fetch() {

    List<RealTimeData> realTimeDataList = new ArrayList<>();
    collectPointMap.put("1",1);
    collectPointMap.put("2",2);
    collectPointMap.put("3",3);
    collectPointMap.put("0",0);


    collectPointMap.keySet().forEach(key -> {
      Integer type = collectPointMap.get(key);
      if (type != null) {
        CollectionPoint collectionPoint = CollectionPoint.getCollectionPoint(type);
        RealTimeData data = getPoint(collectionPoint, key);
        realTimeDataList.add(data);
      }
    });

    return realTimeDataList;
  }


  /**
   * 通过类型和id生成一个节点数据
   * @param type
   * @param collectPointCode
   * @return
   */
  public RealTimeData getPoint(CollectionPoint type, String collectPointCode) {
    switch (type) {
      case REFUELING_POINT:
        return getOneRefuelingPoint(collectPointCode);
      case DI_POINT:
        return getOneDIPoint(collectPointCode);
      case AI_POINT:
        return getOneAIPoint(collectPointCode);
      case CONDITION_POINT:
        return getOneConditionPoint(collectPointCode);
      default:
        log.error("mock getPoint not find type collectPointCode : {}", collectPointCode);
        return null;
    }
  }


  /**
   * 获取一个加油点对象
   */
  private RealTimeData getOneRefuelingPoint(String collectPointCode) {
    return new RealTimeData(new ObjectId(companyId), collectPointCode,
                            refuelingPointState.get(random.nextInt(refuelingPointState.size()))
                                .toString());
  }

  /**
   * 获取一个DI点
   */
  private RealTimeData getOneDIPoint(String collectPointCode) {
    return new RealTimeData(new ObjectId(companyId), collectPointCode,
                            diPointState.get(random.nextInt(diPointState.size())).toString());
  }

  /**
   * 获取一个ai点
   */
  private RealTimeData getOneAIPoint(String collectPointCode) {
    return new RealTimeData(new ObjectId(companyId), collectPointCode,
                            randomLong.nextFloat() + " ℃");
  }

  /**
   * 获取一个状态点
   */
  private RealTimeData getOneConditionPoint(String collectPointCode) {
    return new RealTimeData(new ObjectId(companyId), collectPointCode,
                            conditionPointState.get(random.nextInt(conditionPointState.size())));
  }
}
