package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.Model.Gpu;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.GpuRepository;
import nl.belastingdienst.pcconfigurator.service.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gpu")
public class GpuController {

    @Autowired
    private GpuService gpuService;

    @GetMapping("/all")
    public Iterable<Gpu> getAllGpu(){
        return gpuService.getAllGpu();
    }

    @GetMapping
    public Gpu getGpuById(@RequestParam Long id){
    return gpuService.getGpuById(id);
    }

    @PostMapping("/populate")
    public ResponseEntity<Object> autoPopulateDatabse(){
        gpuService.autoPopulateDatabase();
        return ResponseEntity.created(null).build();
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
