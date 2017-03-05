package org.votusoperandi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
public class Proposition extends AbstractPersistable<Long> {

    @JsonProperty
    private String description;

    public Proposition() {}

    public Proposition(String s) {
        description = s;
    }


}
