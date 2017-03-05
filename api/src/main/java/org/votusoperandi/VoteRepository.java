package org.votusoperandi;

import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<MajorityVote, Long> {



}
