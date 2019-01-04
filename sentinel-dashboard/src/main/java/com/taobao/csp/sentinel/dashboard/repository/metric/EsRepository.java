package com.taobao.csp.sentinel.dashboard.repository.metric;

import java.util.Date;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRepository extends ElasticsearchRepository<EsMetricEntity, String> {

  List<EsMetricEntity> getResourceByAppAndTimestampAfter(String app, Date start);
  List<EsMetricEntity> getByAppAndResourceAndTimestampBetween(String app,String resource,Date from,Date to);
}
