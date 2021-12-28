package com.spartan.spartanbrain.domain.model.country;

import com.spartan.spartanbrain.domain.model.student.Student;
import com.spartan.spartanbrain.domain.shared.AbstractSharedEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;

@Slf4j
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Cacheable(false)
@Table(name = "SPTN_SPAPI_COUNTRY",
        indexes = {@Index(name = "SPTN_SPAPI_COUNTRY_ID_U1", columnList = "COUNTRY_ID", unique = true)})
public class Country extends AbstractSharedEntity<Country> {

    @Id
    @Column(name = "COUNTRY_ID", unique = true, nullable = false)
    @SequenceGenerator(name = "OALCN_SPI_SEQ", sequenceName = "OALCN_SPI_SEQ", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OALCN_SPI_SEQ")
    private Long CountryId;

    @Column(name = "COUNTRY", length = 240, nullable = false)
    private String country;

    @Override
    public boolean merge(Country other) {
        log.debug("Change number this:{} - Change number other:{}", this.getChangeNumber(), other.getChangeNumber());
        if (other.getChangeNumber() > this.getChangeNumber()) {
            this.setChangeNumber(other.getChangeNumber());

            if (!this.sameIdentityAs(other)) {
                this.country = other.country;
                this.setChangeNumber(other.getChangeNumber());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean sameIdentityAs(Country other) {
        return other != null && new EqualsBuilder().append(this, other).isEquals();
    }

}
