package org.votusoperandi.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MajorityVote extends AbstractPersistable<Long> {

    @ManyToOne
    private Proposition selectedProposition;

    public MajorityVote(){}

    public MajorityVote(Proposition selected) {
        this.selectedProposition = selected;
    }

    public Proposition getSelectedProposition(){
        return selectedProposition;
    }

}
