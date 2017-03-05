package org.votusoperandi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Election extends AbstractPersistable<Long> {

    @JsonProperty
    private String title;

    @JsonProperty
    private String subject;

    @JsonProperty
    private boolean closed = false;

    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL)
    private List<Proposition> propositions = new ArrayList<>();

    public Election(){}

    public Election(String title, String subject, String... propositions) {
        this.subject = subject;
        this.propositions = Arrays.stream(propositions).map(Proposition::new).collect(Collectors.toList());
    }

    public List<Proposition> getPropositions(){
        return propositions;
    }

    public boolean isClosed() {
        return closed;
    }

    public void updateWith(Election modified) {
        this.closed = modified.isClosed();
    }
}