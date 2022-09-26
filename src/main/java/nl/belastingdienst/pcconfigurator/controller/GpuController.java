package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.model.Gpu;
import nl.belastingdienst.pcconfigurator.dto.GpuDto;
import nl.belastingdienst.pcconfigurator.service.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gpu")
public class GpuController {

    @Autowired
    private GpuService gpuService;

    @GetMapping("/all")
    public ResponseEntity<List<GpuDto>> getAllGpu(){
        return ResponseEntity.ok(gpuService.getAllGpu());
    }

    @GetMapping
    public ResponseEntity<GpuDto> getGpuById(@RequestParam Long id){
    return ResponseEntity.ok(gpuService.getGpuById(id));
    }

    @PostMapping
    public ResponseEntity<Object> newGpu(@RequestBody Gpu gpu){
        gpuService.newGpu(gpu);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Gpu> updateGpu(@RequestParam Long id, @RequestBody Gpu newGpu){
        gpuService.updateGpu(id, newGpu);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteGpuById(@RequestParam Long id){
        gpuService.deleteGpuById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllGpu(){
        gpuService.deleteAllGpu();
        return ResponseEntity.ok().build();
    }
}
