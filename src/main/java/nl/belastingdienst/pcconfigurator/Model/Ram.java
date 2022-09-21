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
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String productLine;
    private String ddr;
    private int clockSpeed;
    private int size;

    public Ram() {
    }

    public Ram(String brand, String productLine, String ddr, int clockSpeed, int size) {
        this.brand = brand;
        this.productLine = productLine;
        this.ddr = ddr;
        this.clockSpeed = clockSpeed;
        this.size = size;
    }
}
