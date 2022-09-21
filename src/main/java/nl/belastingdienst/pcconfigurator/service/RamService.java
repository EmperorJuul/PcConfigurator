package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Ram;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RamService {

    @Autowired
    private RamRepository ramRepository;

    public Iterable<Ram> getAllRam(){
        return ramRepository.findAll();
    }

    public Ram getRamById(Long id){
        return ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
    }

    public ResponseEntity<Object> autoPopulateDatabase(){
        Ram ram1 = new Ram("Corsair", "Vengeance Pro", "ddr4", 3600, 16);
        Ram ram2 = new Ram("Corsair", "Vengeance", "ddr4", 3200, 16);
        Ram ram3 = new Ram("GSkill", "Aegis", "ddr4", 3200, 8);
        Ram ram4 = new Ram("Kingston", "Fury", "ddr4", 3200, 16);
        ramRepository.save(ram1);
        ramRepository.save(ram2);
        ramRepository.save(ram3);
        ramRepository.save(ram4);
        return ResponseEntity.created(null).build();
    }

    public ResponseEntity<Object> newRam(Ram ram){
        ramRepository.save(ram);
        return ResponseEntity.created(null).build();
    }

    public ResponseEntity<Object> updateRam(Long id, Ram newRam){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        newRam.setId(ram.getId());
        ramRepository.save(newRam);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> deleteRamById(Long id){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        ramRepository.delete(ram);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> deleteAllRam(){
        ramRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
