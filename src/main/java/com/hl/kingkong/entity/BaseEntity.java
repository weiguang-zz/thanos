package com.hl.kingkong.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

  @Column(name = "is_deleted", columnDefinition = "TINYINT default 0", nullable = false)
  protected int isDeleted = 0;

  @Column(name = "created_by", nullable = false)
  private String createdBy;

  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @Column(name = "last_modified_by",nullable = false)
  private String lastModifiedBy;

  @Column(name = "last_modified_at", nullable = false)
  private Date lastModifiedAt;


  @PrePersist
  protected void prePersist() {
    if (this.createdAt == null) createdAt = new Date();
    if (this.lastModifiedAt == null) lastModifiedAt = new Date();
  }

  @PreUpdate
  protected void preUpdate() {
    this.lastModifiedAt = new Date();
  }

  @PreRemove
  protected void preRemove() {
    this.lastModifiedAt = new Date();
  }

  protected ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).omitNullValues()
        .add("createdBy", createdBy)
        .add("createdAt", createdAt)
        .add("lastModifiedBy", lastModifiedBy)
        .add("lastModifiedAt", lastModifiedAt);
  }

  public String toString(){
    return toStringHelper().toString();
  }
}
