package org.votusoperandi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ElectionController {

    static Map<Long, Election> datas = new HashMap<>();
    static {
        datas.put(1L, new Election("Quel est votre couleur préférée ?", "noir", "marron", "vert", "auburn"));
        datas.put(2L, new Election("Quel est votre candidat-e préféré-e ?", "Jacques", "Nadine", "Aude", "Jimmy"));
        datas.put(3L, new Election("Quel est votre animal préféré ?", "éléphant", "souris", "pie"));
    }

    @RequestMapping("/election/{id}")
    public Election findOne(@PathVariable Long id){
        Election result = datas.get(id);
        if (result == null) throw new ResourceNotFoundException();
        return result;
    }

    @RequestMapping("/election")
    public Collection<Election> findAll(){
        return datas.values();
    }
}
