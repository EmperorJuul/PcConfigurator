package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Psu;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.PsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PsuService {

    @Autowired
    private PsuRepository psuRepository;

    public Iterable<Psu> getAllPsu(){
        return psuRepository.findAll();
    }

    public Psu getPsuById(Long id){
        return psuRepository.findById(id).orElseThrow(() -> new NotFoundException("No psu found with this id"));
    }

    public void autoPopulateDatabase(){
        Psu psu1 = new Psu("Corsair", "RM750X", 750);
        Psu psu2 = new Psu("Cooler Master", "MWE V2 750", 750);
        Psu psu3 = new Psu("EVGA", "Supernova 750", 750);
        Psu psu4 = new Psu("Gigabyte", "GP-P7750GM", 750);
        psuRepository.save(psu1);
        psuRepository.save(psu2);
        psuRepository.save(psu3);
        psuRepository.save(psu4);
    }

    public void newPsu(Psu psu){
        psuRepository.save(psu);
    }

    public void updatePsu(Long id, Psu newPsu){
        Psu psu = psuRepository.findById(id).orElseThrow(() -> new NotFoundException("No psu found with this id"));
        newPsu.setId(psu.getId());
        psuRepository.save(newPsu);
    }

    public void deletePsuById(Long id){
        Psu psu = psuRepository.findById(id).orElseThrow(() -> new NotFoundException("No psu found with this id"));
        psuRepository.delete(psu);
    }

    public void deleteAllPsu(){
        psuRepository.deleteAll();
    }
}
