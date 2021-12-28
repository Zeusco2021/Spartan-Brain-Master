package com.spartan.spartanbrain.domain.utils;

import com.spartan.spartanbrain.domain.shared.ValueObject;
import lombok.Generated;

public enum HealthStatus implements ValueObject<HealthStatus> {

    // @formatter:off
    RED,
    YELLOW,
    GREEN,
    NOINFO;
    // @formatter:on

    @Override
    @Generated
    public boolean sameValueAs(final HealthStatus other) {

        return this.equals(other);
    }
}