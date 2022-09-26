package nl.belastingdienst.pcconfigurator.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
public class CpuDto {

    @NotNull
    private Long id;
    private String brand;
    private String productLine;
    private int generation;
    private int tier;
    private int modelNumber;
    private String suffix;
    private String socket;
    private boolean hasIGpu;

    public CpuDto(String brand, String productLine, int generation, int tier, int modelNumber, String suffix, String socket, boolean hasIGpu) {
        this.brand = brand;
        this.productLine = productLine;
        this.generation = generation;
        this.tier = tier;
        this.modelNumber = modelNumber;
        this.suffix = suffix;
        this.socket = socket;
        this.hasIGpu = hasIGpu;
    }

}
