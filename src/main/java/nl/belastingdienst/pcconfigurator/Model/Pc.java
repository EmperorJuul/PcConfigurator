package nl.belastingdienst.pcconfigurator.Model;

import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;

@Entity
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
