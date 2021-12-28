/*
 * =============================================================================
 *   Copyright (c) 2021, 2028 Omar Cervantes and/or its affiliates. All rights reserved.
 *
 * =============================================================================
 *
 */
package com.spartan.spartanbrain.domain.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import javax.persistence.Column;
//import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Abstract Implementation of the {@link Entity} to provide default behavior. Entity classes must Extend this Abstract
 * Class.
 *
 * @author srnagesh
 */
@MappedSuperclass
////@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class AbstractEntity<T> implements Entity<T> {

  @Column(name = "CREATED_BY", nullable = false, length = 240)
  @CreatedBy
  private String createdBy;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
    timezone = "UTC"
  )
  @Column(name = "CREATION_DATE", nullable = false)
  @CreatedDate
  private Instant creationDate;

  @Column(name = "LAST_UPDATED_BY", nullable = false, length = 240)
  @LastModifiedBy
  private String lastUpdatedBy;

  @JsonFormat(
    shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
    timezone = "UTC"
  )
  @Column(name = "LAST_UPDATE_DATE", nullable = false)
  @LastModifiedDate
  private Instant lastUpdateDate;

  @Column(name = "VERSION")
  @Version
  private long version;
}
