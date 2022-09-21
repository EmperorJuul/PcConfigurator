package nl.belastingdienst.pcconfigurator.repository;

import nl.belastingdienst.pcconfigurator.Model.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Long> {
}
