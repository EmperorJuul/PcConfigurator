package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.Model.Psu;
import nl.belastingdienst.pcconfigurator.Model.Ram;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.RamRepository;
import nl.belastingdienst.pcconfigurator.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ram")
public class RamController {

    @Autowired
    private RamService ramService;

    @GetMapping("/all")
    public Iterable<Ram> getAllRam(){
        return ramService.getAllRam();
    }

    @GetMapping()
    public Ram getRamById(@RequestParam Long id){
        return ramService.getRamById(id);
    }

    @PostMapping("/populate")
    public ResponseEntity<Object> autoPopulateDatabase(){
        return ramService.autoPopulateDatabase();
    }

    @PostMapping
    public ResponseEntity<Object> newRam(@RequestBody Ram ram){
        return ramService.newRam(ram);
    }

    @PutMapping
    public ResponseEntity<Object> updateRam(@RequestParam Long id, @RequestBody Ram newRam){
        return ramService.updateRam(id, newRam);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteRamById(@RequestParam Long id){
        return ramService.deleteRamById(id);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllRam(){
        return ramService.deleteAllRam();
    }
}
