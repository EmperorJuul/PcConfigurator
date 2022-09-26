package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.model.Cpu;
import nl.belastingdienst.pcconfigurator.dto.CpuDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
