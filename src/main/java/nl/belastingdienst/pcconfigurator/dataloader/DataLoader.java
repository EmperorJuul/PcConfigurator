package nl.belastingdienst.pcconfigurator.dataloader;

import nl.belastingdienst.pcconfigurator.model.Cpu;
import nl.belastingdienst.pcconfigurator.model.Gpu;
import nl.belastingdienst.pcconfigurator.model.Psu;
import nl.belastingdienst.pcconfigurator.model.Ram;
import nl.belastingdienst.pcconfigurator.repository.CpuRepository;
import nl.belastingdienst.pcconfigurator.repository.GpuRepository;
import nl.belastingdienst.pcconfigurator.repository.PsuRepository;
import nl.belastingdienst.pcconfigurator.repository.RamRepository;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader {

    private CpuRepository cpuRepository;
    private GpuRepository gpuRepository;
    private PsuRepository psuRepository;
    private RamRepository ramRepository;



    public DataLoader(CpuRepository cpuRepository, GpuRepository gpuRepository, PsuRepository psuRepository, RamRepository ramRepository) {
        this.cpuRepository = cpuRepository;
        this.gpuRepository = gpuRepository;
        this.psuRepository = psuRepository;
        this.ramRepository = ramRepository;
        Load();
    }

    public void Load(){
        Cpu cpu1 = new Cpu("Amd", "Ryzen", 5, 5, 600, "G", "AM4", true);
        Cpu cpu2 = new Cpu("Intel", "CoreI", 5, 11, 400, "F", "LGA1200", false);
        Cpu cpu3 = new Cpu("Amd", "Ryzen", 7, 5, 800, "X", "am4", false);
        Cpu cpu4 = new Cpu("Intel", "CoreI", 7, 12, 700, "K", "LGA1700", false);
        cpuRepository.save(cpu1);
        cpuRepository.save(cpu2);
        cpuRepository.save(cpu3);
        cpuRepository.save(cpu4);

        Gpu gpu1 = new Gpu("Nvidia", "RTX", 30, 60, "",12);
        Gpu gpu2 = new Gpu("Amd", "Radeon", 6, 800, "RX", 16);
        Gpu gpu3 = new Gpu("Nvidia", "RTX", 16, 50, "", 4);
        Gpu gpu4 = new Gpu("Amd", "Radeon", 5, 80, "RX", 8);
        gpuRepository.save(gpu1);
        gpuRepository.save(gpu2);
        gpuRepository.save(gpu3);
        gpuRepository.save(gpu4);

        Psu psu1 = new Psu("Corsair", "RM750X", 750);
        Psu psu2 = new Psu("Cooler Master", "MWE V2 750", 750);
        Psu psu3 = new Psu("EVGA", "Supernova 750", 750);
        Psu psu4 = new Psu("Gigabyte", "GP-P7750GM", 750);
        psuRepository.save(psu1);
        psuRepository.save(psu2);
        psuRepository.save(psu3);
        psuRepository.save(psu4);

        Ram ram1 = new Ram("Corsair", "Vengeance Pro", "ddr4", 3600, 16);
        Ram ram2 = new Ram("Corsair", "Vengeance", "ddr4", 3200, 16);
        Ram ram3 = new Ram("GSkill", "Aegis", "ddr4", 3200, 8);
        Ram ram4 = new Ram("Kingston", "Fury", "ddr4", 3200, 16);
        ramRepository.save(ram1);
        ramRepository.save(ram2);
        ramRepository.save(ram3);
        ramRepository.save(ram4);
    }
}
