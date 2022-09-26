package nl.belastingdienst.pcconfigurator.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GpuDto {

    @NotNull
    private long id;
    private String brand;
    private String productLine;
    private int generation;
    private int modelNumber;
    private String suffix;
    private int vram;

    public GpuDto(String brand, String productLine, int generation, int modelNumber, String suffix, int vram) {
        this.id = id;
        this.brand = brand;
        this.productLine = productLine;
        this.generation = generation;
        this.modelNumber = modelNumber;
        this.suffix = suffix;
        this.vram = vram;
    }


}
