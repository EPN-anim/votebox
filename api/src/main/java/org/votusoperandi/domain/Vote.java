package org.votusoperandi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Vote extends AbstractPersistable<Long> {

    @ManyToOne
    private Proposition selectedProposition;

    @JsonProperty
    private String userName;

    @JsonProperty
    private Boolean majorityVote;

    @JsonProperty
    private Integer scoreVote;

    public Vote(){}

    public Vote(Proposition selected) {
        this.selectedProposition = selected;
    }

    public Proposition getSelectedProposition(){
        return selectedProposition;
    }

    public void updateWith(Vote userVote) {
        this.majorityVote = userVote.majorityVote;
        this.scoreVote = userVote.scoreVote;
        this.userName = userVote.userName;
    }
}