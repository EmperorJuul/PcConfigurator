package nl.belastingdienst.pcconfigurator.service;

import nl.belastingdienst.pcconfigurator.dto.CpuDto;
import nl.belastingdienst.pcconfigurator.model.Cpu;
import nl.belastingdienst.pcconfigurator.repository.CpuRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CpuServiceTest {

    @Mock
    CpuRepository cpuRepository;

    @InjectMocks
    CpuService cpuService;

    @Mock
    Cpu cpu;

    @BeforeEach
    public void setup(){
        cpu = new Cpu("Amd", "Ryzen", 5, 5, 600, "G", "AM4", true);
    }

    @Test
    public void getCpyById(){
        CpuDto expected = new CpuDto("Amd", "Ryzen", 5, 5, 600, "G", "AM4", true);

        Mockito
                .when(cpuRepository.findById(cpu.getId()))
                .thenReturn(Optional.of(cpu));

        CpuDto actual = cpuService.getCpuById(cpu.getId());

        assertEquals(actual, expected);
    }

}