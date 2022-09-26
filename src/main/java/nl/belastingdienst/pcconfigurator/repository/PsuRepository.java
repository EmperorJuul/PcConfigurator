package nl.belastingdienst.pcconfigurator.repository;

import nl.belastingdienst.pcconfigurator.model.Psu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsuRepository extends JpaRepository<Psu, Long> {

}
