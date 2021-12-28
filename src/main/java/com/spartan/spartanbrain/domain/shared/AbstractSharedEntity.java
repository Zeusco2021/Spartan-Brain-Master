package com.spartan.spartanbrain.domain.shared;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract Implementation of {@link SharedEntity}. Shared Models are required to extend from this Class.
 *
 * @author oocervan
 */
@EqualsAndHashCode(callSuper = true, exclude = "changeNumber")
@MappedSuperclass
@Setter(AccessLevel.PROTECTED)
@Getter(AccessLevel.PUBLIC)
public abstract class AbstractSharedEntity<T> extends AbstractEntity<T> implements SharedEntity<T> {

    @Column(name = "CHANGE_NUMBER")
    private long changeNumber;
}

