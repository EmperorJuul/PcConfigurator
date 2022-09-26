package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.model.Ram;
import nl.belastingdienst.pcconfigurator.dto.RamDto;
import nl.belastingdienst.pcconfigurator.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ram")
public class RamController {

    @Autowired
    private RamService ramService;

    @GetMapping("/all")
    public ResponseEntity<List<RamDto>> getAllRam(){
        return ResponseEntity.ok(ramService.getAllRam());
    }

    @GetMapping()
    public ResponseEntity<RamDto> getRamById(@RequestParam Long id){
        return ResponseEntity.ok(ramService.getRamById(id));
    }

    @PostMapping
    public ResponseEntity<Object> newRam(@RequestBody Ram ram){
        ramService.newRam(ram);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Object> updateRam(@RequestParam Long id, @RequestBody Ram newRam){
        ramService.updateRam(id, newRam);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteRamById(@RequestParam Long id){
        ramService.deleteRamById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllRam(){
        ramService.deleteAllRam();
        return ResponseEntity.ok().build();
    }
}
