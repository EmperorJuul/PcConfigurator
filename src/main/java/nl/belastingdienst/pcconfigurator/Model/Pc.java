package nl.belastingdienst.pcconfigurator.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
