package nl.belastingdienst.pcconfigurator.Model;

import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;

@Entity
@Table(name = "pcs")
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpus")
    private Cpu cpu;

    @ManyToOne
    @JoinColumn(name = "gpus")
    private Gpu gpu;

    @ManyToOne
    @JoinColumn(name = "psus")
    private Psu psu;

    @ManyToOne
    @JoinColumn(name = "rams")
    private Ram ram;

}
