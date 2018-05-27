package com.dm.thanos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Create by zhangzheng on 5/2/18
 */
@Entity
@Table
@SQLDelete(sql = "update equipment set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class Equipment extends BaseEntity{
  @Id
  @GeneratedValue
  @Column
  long id;
  @Column(nullable = false)
  String name;
  @Column(nullable = false)
  long number;
  @Column(nullable = false)
  String specification;
  @Column(nullable = false)
  String type;
  @Column
  String vendor;
  @Column
  String installLocation;
  @Column
  String department;
  @Column
  String purpose;
  @Column
  String parameters;

}
