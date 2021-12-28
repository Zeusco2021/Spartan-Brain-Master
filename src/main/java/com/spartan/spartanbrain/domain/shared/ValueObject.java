/* =============================================================================
 *   Copyright (c) 2021, 2028 Omar Cervantes and/or its affiliates. All rights reserved.
 *
 * =============================================================================
 *
 */
package com.spartan.spartanbrain.domain.shared;

import java.io.Serializable;

/**
 * A Value Object that is immutable, can be replaced with another, comparable with other Value Objects w.r.t. to
 * attributes. Measures, quantifies or describes a thing in the Domain.
 *
 * @author ocervant
 */
public interface ValueObject<T> extends Serializable {
  /**
   * Value objects compare by the values of their attributes, they don't have an identity.
   *
   * @param other The other value object.
   * @return <code>true</code> if the given value object's and this value object's attributes are the same.
   */
  boolean sameValueAs(T other);
}
