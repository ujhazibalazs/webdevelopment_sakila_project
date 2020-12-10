package hu.unideb.webdev.spring_data.dao;

import lombok.Data;

public enum Rating {

    GENERAL_AUDIENCES("G"),
    PARENTAL_GUIDANCE_SUGGESTED("PG"),
    PARENTS_STRONGLY_CAUTIONED("PG-13"),
    RESTRICTED("R"),
    ADULTS_ONLY("NC-17");

    public String getS() {
        return s;
    }

    String s;

    Rating(String s) {
        this.s = s;
    }

}
