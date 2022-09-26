package nl.belastingdienst.pcconfigurator.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RamDto {

    @NotNull
    private long id;
    private String brand;
    private String productLine;
    private String ddr;
    private int clockSpeed;
    private int size;

    public RamDto(String brand, String productLine, String ddr, int clockSpeed, int size) {
        this.id = id;
        this.brand = brand;
        this.productLine = productLine;
        this.ddr = ddr;
        this.clockSpeed = clockSpeed;
        this.size = size;
    }

}
