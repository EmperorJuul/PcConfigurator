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
public class Cpu {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String productLine;
    private int generation;
    private int tier;
    private int modelNumber;
    private String suffix;
    private String socket;
    private boolean hasIGpu;


    public Cpu(String brand, String productLine, int tier, int generation, int modelNumber, String suffix, String socket, boolean hasIGpu) {
        this.brand = brand;
        this.productLine = productLine;
        this.tier = tier;
        this.generation = generation;
        this.modelNumber = modelNumber;
        if(suffix == null){this.suffix = "";}
        else{this.suffix = suffix;}
        this.socket = socket;
        this.hasIGpu = hasIGpu;
    }

    public Cpu() {
    }
}
