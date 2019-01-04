package com.taobao.csp.sentinel.dashboard.repository.metric;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Data;
import org.elasticsearch.common.UUIDs;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "laidian-metric", type = "sentinel")
class EsMetricEntity implements Serializable {
  @Id
  @Field
  private String id= UUIDs.randomBase64UUID();
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date gmtCreate;
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date gmtModified;
  @Field(type = FieldType.Text)
  private String app;
  /**
   * 监控信息的时间戳
   */
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date timestamp;
  @Field(type = FieldType.Text)
  private String resource;
  @Field(index = false, type = FieldType.Long)
  private Long passQps;
  @Field(index = false, type = FieldType.Long)
  private Long successQps;
  @Field(index = false, type = FieldType.Long)
  private Long blockQps;
  /**
   * 发生异常的次数
   */
  @Field(index = false, type = FieldType.Long)
  private Long exceptionQps;

  /**
   * 所有successQps的Rt的和。
   */
  @Field(index = false, type = FieldType.Double)
  private double rt;

  /**
   * 本次聚合的总条数
   */
  @Field(index = false, type = FieldType.Integer)
  private int count;
  @Field(index = false, type = FieldType.Integer)
  private int resourceCode;
}
