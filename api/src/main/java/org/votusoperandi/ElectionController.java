package org.votusoperandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/election/{electionId}/vote", method = RequestMethod.POST)
    public MajorityVote vote(@PathVariable Long electionId, @RequestBody MajorityVote userVote){
        Election result = getElectionOrThrowException(electionId);
        ElectionOption selected = result.getOptions().stream().filter(v -> v.getId().equals(userVote.getSelectedOption().getId())).findFirst().orElseThrow(ResourceNotFoundException::new);
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
