package nl.belastingdienst.pcconfigurator.repository;

import nl.belastingdienst.pcconfigurator.model.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamRepository extends JpaRepository<Ram, Long> {
}
