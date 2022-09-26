package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.model.Gpu;
import nl.belastingdienst.pcconfigurator.dto.GpuDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GpuService {

    @Autowired
    private GpuRepository gpuRepository;

    public List<GpuDto> getAllGpu(){
        List<Gpu> gpuList = gpuRepository.findAll();
        List<GpuDto> gpuDtoList = new ArrayList<>();
        for(Gpu gpu : gpuList){
            gpuDtoList.add(fromGpuToGpuDto(gpu));
        }
        return gpuDtoList;
    }

    public GpuDto getGpuById(Long id) {
        return fromGpuToGpuDto(gpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No gpu found with this id")));
    }

    public void newGpu(Gpu gpu){
        gpuRepository.save(gpu);
    }

    public void updateGpu(Long id, Gpu newGpu){
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No gpu found with that id"));
        newGpu.setId(gpu.getId());
        gpuRepository.save(newGpu);
    }

    public void deleteGpuById(Long id){
        Gpu gpu = gpuRepository.findById(id).orElseThrow(() -> new NotFoundException("No gpu found with this id"));
        gpuRepository.delete(gpu);
    }

    public void deleteAllGpu(){
        gpuRepository.deleteAll();
    }

    private GpuDto fromGpuToGpuDto(Gpu gpu){
        GpuDto gpuDto = new GpuDto(
                gpu.getBrand(),
                gpu.getProductLine(),
                gpu.getGeneration(),
                gpu.getModelNumber(),
                gpu.getSuffix(),
                gpu.getVram());

        return gpuDto;
    }

}
