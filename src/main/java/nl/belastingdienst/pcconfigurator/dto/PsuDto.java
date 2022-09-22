package nl.belastingdienst.pcconfigurator.dto;

import nl.belastingdienst.pcconfigurator.Model.Pc;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PsuDto {

    @NotNull
    private long id;
    private String brand;
    private String model;
    private int wattage;

    public PsuDto(long id, String brand, String model, int wattage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.wattage = wattage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
