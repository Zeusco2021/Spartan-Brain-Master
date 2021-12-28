package com.spartan.spartanbrain.domain.model.language;


import org.apache.commons.lang3.builder.EqualsBuilder;
import com.spartan.spartanbrain.domain.shared.AbstractSharedEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

@Slf4j
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Cacheable(false)
@Table(name = "SPTN_SPAPI_LANGUAGE",
        indexes = {@Index(name = "SPTN_SPAPI_LANGUAGE_ID_U1", columnList = "LANGUAGE_ID", unique = true)})
public class Language extends AbstractSharedEntity<Language> {

    @Id
    @Column(name = "LANGUAGE_ID", unique = true, nullable = false)
    @SequenceGenerator(name = "OALCN_SPI_SEQ", sequenceName = "OALCN_SPI_SEQ", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OALCN_SPI_SEQ")
    private Long languageId;

    @Column(name = "LANGUAGE_NAME", length = 100, nullable = false)
    private String languageName;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(languageId, language.languageId) && Objects.equals(languageName, language.languageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, languageName);
    }

    @Override
    public boolean sameIdentityAs(Language other) {
        return other != null && new EqualsBuilder().append(this, other).isEquals();
    }

    @Override
    public boolean merge(Language other) {
        return false;
    }
}
