package org.votusoperandi;

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
    private String subject;
    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL)
    private List<ElectionOption> options = new ArrayList<>();

    public Election(){}

    public Election(String subject, String...options) {
        this.subject = subject;
        this.options = Arrays.stream(options).map(ElectionOption::new).collect(Collectors.toList());
    }

    public List<ElectionOption> getOptions(){
        return options;
    }

}