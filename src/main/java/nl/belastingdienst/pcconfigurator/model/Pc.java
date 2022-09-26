package nl.belastingdienst.pcconfigurator.model;

import javax.persistence.*;

@Entity
@Table(name = "pcs")
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cpu cpu;

    @ManyToOne
    private Gpu gpu;

    @ManyToOne
    private Psu psu;

    @ManyToOne
    private Ram ram;

}
