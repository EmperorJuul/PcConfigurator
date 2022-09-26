package nl.belastingdienst.pcconfigurator.repository;

import nl.belastingdienst.pcconfigurator.model.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
