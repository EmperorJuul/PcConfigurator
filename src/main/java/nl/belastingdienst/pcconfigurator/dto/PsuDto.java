package nl.belastingdienst.pcconfigurator.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PsuDto {

    @NotNull
    private long id;
    private String brand;
    private String model;
    private int wattage;

    public PsuDto(String brand, String model, int wattage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
    }


}
