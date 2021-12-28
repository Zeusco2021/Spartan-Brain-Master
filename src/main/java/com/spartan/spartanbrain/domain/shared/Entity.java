/*
 * =============================================================================
 *   Copyright (c) 2021, 2028 Omar Cervantes and/or its affiliates. All rights reserved.
 *
 * =============================================================================
 *
 */
package com.spartan.spartanbrain.domain.shared;

/**
 *
 * @author ocervantes
 *
 */
public interface Entity<T> {
  /**
   * Entities compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardles of other attributes.
   */
  boolean sameIdentityAs(T other);
}
