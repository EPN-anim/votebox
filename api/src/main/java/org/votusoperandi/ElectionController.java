package org.votusoperandi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ElectionController {

    @Autowired
    private ElectionRepository electionRepository;


    @RequestMapping("/election/{id}")
    public Election findOne(@PathVariable Long id){
        Election result = electionRepository.findOne(id);
        if (result == null) throw new ResourceNotFoundException();
        return result;
    }

    @RequestMapping("/election")
    public Iterable<Election> findAll(){
        return electionRepository.findAll();
    }
}
