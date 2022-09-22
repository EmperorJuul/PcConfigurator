package nl.belastingdienst.pcconfigurator.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rams")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String productLine;
    private String ddr;
    private int clockSpeed;
    private int size;

    @OneToMany
    private List<Pc> pcList;

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
