package org.votusoperandi.repository;

import org.springframework.data.repository.CrudRepository;
import org.votusoperandi.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {



}
