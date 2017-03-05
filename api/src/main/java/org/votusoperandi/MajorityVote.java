package org.votusoperandi;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MajorityVote extends AbstractPersistable<Long> {

    @ManyToOne
    private ElectionOption selectedOption;

    public MajorityVote(){}

    public MajorityVote(ElectionOption selected) {
        this.selectedOption = selected;
    }

    public ElectionOption getSelectedOption(){
        return selectedOption;
    }

}
