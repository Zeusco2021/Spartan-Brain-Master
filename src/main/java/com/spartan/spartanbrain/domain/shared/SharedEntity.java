package com.spartan.spartanbrain.domain.shared;

/**
 * Entity Interface for Shared Models. Typically extended by {@link AbstractSharedEntity} Class which is extended by
 * Shared Models.
 *
 * @author ocervan
 */
public interface SharedEntity<T> {

    /**
     * Merge the given Object into this. Typically this merge will do the following <ol> <li>Proceed with the merge if
     * the incoming Object's changeNumber will be > than this.changeNumber</li> <li>Proceed if the Object's are not
     * equal based on the attributes</li> </ol>
     *
     * @param other entity that should be merged into this
     * @return true if the merge is successful
     */
    boolean merge(T other);

}
