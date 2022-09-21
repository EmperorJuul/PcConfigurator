package nl.belastingdienst.pcconfigurator.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Gpu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String productLine;
    private int generation;
    private int modelNumber;
    private String suffix;
    private int vram;


    public Gpu() {
    }

    public Gpu(String brand, String productLine, int generation, int modelNumber, String suffix, int vram) {
        this.brand = brand;
        this.productLine = productLine;
        this.generation = generation;
        this.modelNumber = modelNumber;
        if(suffix == null){this.suffix = "";}
        else{this.suffix = suffix;}
        this.vram = vram;
    }
}