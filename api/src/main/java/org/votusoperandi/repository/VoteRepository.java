package org.votusoperandi.repository;

import org.springframework.data.repository.CrudRepository;
import org.votusoperandi.domain.MajorityVote;

public interface VoteRepository extends CrudRepository<MajorityVote, Long> {



}
