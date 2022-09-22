package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.Model.Gpu;
import nl.belastingdienst.pcconfigurator.dto.GpuDto;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public void autoPopulateDatabase(){
        Gpu gpu1 = new Gpu("Nvidia", "RTX", 30, 60, "",12);
        Gpu gpu2 = new Gpu("Amd", "Radeon", 6, 800, "RX", 16);
        Gpu gpu3 = new Gpu("Nvidia", "RTX", 16, 50, "", 4);
        Gpu gpu4 = new Gpu("Amd", "Radeon", 5, 80, "RX", 8);
        gpuRepository.save(gpu1);
        gpuRepository.save(gpu2);
        gpuRepository.save(gpu3);
        gpuRepository.save(gpu4);
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
                gpu.getId(),
                gpu.getBrand(),
                gpu.getProductLine(),
                gpu.getGeneration(),
                gpu.getModelNumber(),
                gpu.getSuffix(),
                gpu.getVram());

        return gpuDto;
    }

}
