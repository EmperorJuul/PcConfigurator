package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.model.Ram;
import nl.belastingdienst.pcconfigurator.dto.RamDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void newRam(Ram ram){
        ramRepository.save(ram);
    }

    public void updateRam(Long id, Ram newRam){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        newRam.setId(ram.getId());
        ramRepository.save(newRam);
    }

    public void deleteRamById(Long id){
        Ram ram = ramRepository.findById(id).orElseThrow(() -> new NotFoundException("No ram found with this id"));
        ramRepository.delete(ram);
    }

    public void deleteAllRam(){
        ramRepository.deleteAll();
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
