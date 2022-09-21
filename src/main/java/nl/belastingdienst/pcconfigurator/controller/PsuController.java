package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.Model.Psu;
import nl.belastingdienst.pcconfigurator.exception.NotFoundException;
import nl.belastingdienst.pcconfigurator.repository.PsuRepository;
import nl.belastingdienst.pcconfigurator.service.PsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psu")
public class PsuController {

    @Autowired
    private PsuService psuService;

    @GetMapping("/all")
    public Iterable<Psu> getAllPsu(){
        return psuService.getAllPsu();
    }

    @GetMapping()
    public Psu getPsuById(@RequestParam Long id){
        return psuService.getPsuById(id);
    }

    @PostMapping("/populate")
    public ResponseEntity<Object> autoPopulateDatabase(){
        psuService.autoPopulateDatabase();
        return ResponseEntity.created(null).build();
    }

    @PostMapping
    public ResponseEntity<Object> newPsu(@RequestBody Psu psu){
        psuService.newPsu(psu);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Object> updatePsu(@RequestParam Long id, @RequestBody Psu newPsu){
        psuService.updatePsu(id, newPsu);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePsuById(@RequestParam Long id){
        psuService.deletePsuById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllPsu(){
        psuService.deleteAllPsu();
        return ResponseEntity.ok().build();
    }

}
