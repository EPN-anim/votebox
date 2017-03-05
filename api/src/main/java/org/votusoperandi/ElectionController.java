package org.votusoperandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.votusoperandi.domain.Election;
import org.votusoperandi.domain.Proposition;
import org.votusoperandi.domain.MajorityVote;
import org.votusoperandi.repository.ElectionRepository;
import org.votusoperandi.repository.VoteRepository;


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
    public MajorityVote vote(@PathVariable Long electionId, @RequestBody MajorityVote userVote){
        Election result = getElectionOrThrowException(electionId);
        Proposition selected = result.getPropositions().stream().filter(v -> v.getId().equals(userVote.getSelectedProposition().getId())).findFirst().orElseThrow(ResourceNotFoundException::new);
        MajorityVote vote = new MajorityVote(selected);
        return voteRepository.save(vote);
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
