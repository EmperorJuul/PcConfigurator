package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Psu;
import nl.belastingdienst.pcconfigurator.dto.PsuDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.PsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsuService {

    @Autowired
    private PsuRepository psuRepository;

    public List<PsuDto> getAllPsu(){
        List<Psu> psuList = psuRepository.findAll();
        List<PsuDto> psuDtoList = new ArrayList<>();
        for(Psu psu : psuList){
            psuDtoList.add(fromPsuToPsuDto(psu));
        }
        return psuDtoList;
    }

    public PsuDto getPsuById(Long id){
        return fromPsuToPsuDto(psuRepository.findById(id).orElseThrow(() -> new NotFoundException("No psu found with this id")));
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

    private PsuDto fromPsuToPsuDto(Psu psu){
        PsuDto psuDto = new PsuDto(
                psu.getId(),
                psu.getBrand(),
                psu.getModel(),
                psu.getWattage());

        return psuDto;
    }
}
