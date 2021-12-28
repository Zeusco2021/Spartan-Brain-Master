package com.spartan.spartanbrain.domain.model.language;

import java.util.Objects;

public class Language {

    private Long idLanguage;
    private String languageName;

    public Language() {

    }

    public Language(Long idLanguage, String languageName) {
        this.idLanguage = idLanguage;
        this.languageName = languageName;
    }

    public Long getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Long idLanguage) {
        this.idLanguage = idLanguage;
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
                "idLanguage=" + idLanguage +
                ", languageName='" + languageName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(idLanguage, language.idLanguage) && Objects.equals(languageName, language.languageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLanguage, languageName);
    }
}
