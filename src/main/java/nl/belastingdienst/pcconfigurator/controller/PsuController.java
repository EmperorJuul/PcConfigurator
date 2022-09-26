package nl.belastingdienst.pcconfigurator.controller;

import nl.belastingdienst.pcconfigurator.model.Psu;
import nl.belastingdienst.pcconfigurator.dto.PsuDto;
import nl.belastingdienst.pcconfigurator.service.PsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/psu")
public class PsuController {

    @Autowired
    private PsuService psuService;

    @GetMapping("/all")
    public ResponseEntity<List<PsuDto>> getAllPsu(){
        return ResponseEntity.ok(psuService.getAllPsu());
    }

    @GetMapping()
    public ResponseEntity<PsuDto> getPsuById(@RequestParam Long id){
        return ResponseEntity.ok(psuService.getPsuById(id));
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
