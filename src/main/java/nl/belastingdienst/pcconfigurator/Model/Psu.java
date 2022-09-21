package nl.belastingdienst.pcconfigurator.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Psu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //auto generated
    private long id;
    private String brand;
    private String model;
    private int wattage;

    @OneToMany
    private List<Pc> pcList;

    public Psu() {
    }

    public Psu(String brand, String model, int wattage) {
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
    }
}
