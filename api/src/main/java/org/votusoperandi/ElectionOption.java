package org.votusoperandi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
public class ElectionOption extends AbstractPersistable<Long> {

    @JsonProperty
    private String description;

    public ElectionOption() {}

    public ElectionOption(String s) {
        description = s;
    }
}
