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
    private boolean majorityVote;

    @JsonProperty
    private int scoreVote;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean getMajorityVote() {
        return majorityVote;
    }

    public void setMajorityVote(Boolean majorityVote) {
        this.majorityVote = majorityVote;
    }

    public int getScoreVote() {
        return scoreVote;
    }

    public void setScoreVote(Integer scoreVote) {
        this.scoreVote = scoreVote;
    }

    public void setSelectedProposition(Proposition selectedProposition) {
        this.selectedProposition = selectedProposition;

    }
}