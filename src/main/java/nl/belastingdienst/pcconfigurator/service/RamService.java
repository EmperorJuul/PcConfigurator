package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Ram;
import nl.belastingdienst.pcconfigurator.dto.RamDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class RamService {

    @Autowired
    private RamRepository ramRepository;

    public List<RamDto> getAllRam(){
        List<Ram> ramList = ramRepository.findAll();
        List<RamDto> ramDtoList = new ArrayList<>();
        for(Ram ram: ramList){
            ramDtoList.add(fromRamToRamDto(ram));
        }
        return ramDtoList;
    }

    public RamDto getRamById(Long id){
        return fromRamToRamDto(ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id")));
    }

    public void autoPopulateDatabase(){
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

    public void newRam(Ram ram){
        ramRepository.save(ram);
        return ResponseEntity.created(null).build();
    }

    public void updateRam(Long id, Ram newRam){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        newRam.setId(ram.getId());
        ramRepository.save(newRam);
        return ResponseEntity.ok().build();
    }

    public void deleteRamById(Long id){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        ramRepository.delete(ram);
        return ResponseEntity.ok().build();
    }

    public void deleteAllRam(){
        ramRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    private RamDto fromRamToRamDto(Ram ram){
        RamDto ramDto = new RamDto(
                ram.getId(),
                ram.getBrand(),
                ram.getProductLine(),
                ram.getDdr(),
                ram.getClockSpeed(),
                ram.getSize());

        return ramDto;
    }

}
