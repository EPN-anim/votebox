package org.votusoperandi.repository;

import org.springframework.data.repository.CrudRepository;
import org.votusoperandi.domain.Election;

public interface ElectionRepository extends CrudRepository<Election, Long> {



}
