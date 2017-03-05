package org.votusoperandi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.votusoperandi.domain.Election;
import org.votusoperandi.domain.Vote;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query("from Vote as v where v.selectedProposition.election.id = ?1")
    List<Vote> findByElectionId(Long electionId);

}
