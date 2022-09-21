package nl.belastingdienst.pcconfigurator.repository;

import nl.belastingdienst.pcconfigurator.Model.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
