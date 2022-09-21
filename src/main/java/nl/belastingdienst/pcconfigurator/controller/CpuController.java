package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.Model.Cpu;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.CpuRepository;
import nl.belastingdienst.pcconfigurator.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpu")
public class CpuController {

    @Autowired
    private CpuService cpuService;



    @GetMapping("/all")
    public Iterable<Cpu> getAllCpu() {
        return cpuService.getAllCpu();
    }

    @GetMapping
    public Cpu getCpuById(@RequestParam Long id){
    return cpuService.getCpuById(id);
    }

    @PostMapping("/populate")
    public ResponseEntity<Object> autoPopulateDatabase(){
        cpuService.autoPopulateDatabase();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Object> newCpu(@RequestBody Cpu cpu){
        cpuService.newCpu(cpu);
        return ResponseEntity.created(null).build();
    }

    @PutMapping()
    public ResponseEntity<Object> updateCpu(@RequestParam Long id, @RequestBody Cpu newCpu){
        cpuService.updateCpu(id, newCpu);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCpuById(@RequestParam Long id){
        cpuService.deleteCpuById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllCpu(){
        cpuService.deleteAllCpu();
        return ResponseEntity.ok().build();
    }
}
