package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Cpu;
import nl.belastingdienst.pcconfigurator.dto.CpuDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    public List<CpuDto> getAllCpu() {
        List<Cpu> cpuList = cpuRepository.findAll();
        List<CpuDto> cpuDtoList = new ArrayList<>();
        for(Cpu cpu : cpuList){
            cpuDtoList.add(fromCpuToCpuDto(cpu));
        }
        return cpuDtoList;
    }

    public CpuDto getCpuById(Long id){
        return fromCpuToCpuDto(cpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No cpu found with this is")));
    }

    public void autoPopulateDatabase() {
        Cpu cpu1 = new Cpu("Amd", "Ryzen", 5, 5, 600, "G", "AM4", true);
        Cpu cpu2 = new Cpu("Intel", "CoreI", 5, 11, 400, "F", "LGA1200", false);
        Cpu cpu3 = new Cpu("Amd", "Ryzen", 7, 5, 800, "X", "am4", false);
        Cpu cpu4 = new Cpu("Intel", "CoreI", 7, 12, 700, "K", "LGA1700", false);
        cpuRepository.save(cpu1);
        cpuRepository.save(cpu2);
        cpuRepository.save(cpu3);
        cpuRepository.save(cpu4);
    }

    public void newCpu(Cpu cpu){
        cpuRepository.save(cpu);
    }

    public void updateCpu(Long id, Cpu newCpu){
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No cpu found with this id"));
        newCpu.setId(cpu.getId());
        cpuRepository.save(newCpu);
    }

    public void deleteCpuById(Long id){
        Cpu cpu = cpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No cpu found with this id"));
        cpuRepository.delete(cpu);
    }

    public void deleteAllCpu(){
        cpuRepository.deleteAll();
    }

    private CpuDto fromCpuToCpuDto(Cpu cpu){
        CpuDto cpuDto = new CpuDto(
                cpu.getId(),
                cpu.getBrand(),
                cpu.getProductLine(),
                cpu.getGeneration(),
                cpu.getTier(),
                cpu.getModelNumber(),
                cpu.getSuffix(),
                cpu.getSocket(),
                cpu.isHasIGpu());

        return  cpuDto;
    }

}
