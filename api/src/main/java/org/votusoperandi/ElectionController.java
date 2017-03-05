package org.votusoperandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.votusoperandi.domain.Election;
import org.votusoperandi.domain.Proposition;
import org.votusoperandi.domain.Vote;
import org.votusoperandi.repository.ElectionRepository;
import org.votusoperandi.repository.VoteRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
public class ElectionController {

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping("/election/{id}")
    public Election findOne(@PathVariable Long id){
        return getElectionOrThrowException(id);
    }

    @RequestMapping(value = "/election/{id}", method = RequestMethod.PUT)
    public Election modify(@PathVariable Long id, @RequestBody Election modified){
        Election election = getElectionOrThrowException(id);
        election.updateWith(modified);
        electionRepository.save(election);
        return election;
    }

    @RequestMapping(value = "/election/{electionId}/vote", method = RequestMethod.POST)
    public Collection<Vote> vote(@PathVariable Long electionId, @RequestBody List<Vote> userVotes){
        Election result = getElectionOrThrowException(electionId);
        Collection<Vote> votes = new ArrayList<>(userVotes.size());
        for(Vote userVote:userVotes) {
            Proposition selected = result.getPropositions().stream().filter(v -> v.getId().equals(userVote.getSelectedProposition().getId())).findFirst().orElseThrow(ResourceNotFoundException::new);
            Vote vote = new Vote(selected);
            vote.updateWith(userVote);
            vote = voteRepository.save(vote);
            votes.add(vote);
        }
        return votes;
    }

    private Election getElectionOrThrowException(Long electionId) {
        Election result = electionRepository.findOne(electionId);
        if (result == null) throw new ResourceNotFoundException();
        return result;
    }

    @RequestMapping("/election")
    public Iterable<Election> findAll(){
        return electionRepository.findAll();
    }

    @RequestMapping(value = "/election", method = RequestMethod.POST)
    public Election create(@RequestBody Election election){
        return electionRepository.save(election);
    }



}
