package nl.belastingdienst.pcconfigurator.dto;

import nl.belastingdienst.pcconfigurator.Model.Pc;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RamDto {

    @NotNull
    private long id;
    private String brand;
    private String productLine;
    private String ddr;
    private int clockSpeed;
    private int size;

    public RamDto(long id, String brand, String productLine, String ddr, int clockSpeed, int size) {
        this.id = id;
        this.brand = brand;
        this.productLine = productLine;
        this.ddr = ddr;
        this.clockSpeed = clockSpeed;
        this.size = size;
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

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getDdr() {
        return ddr;
    }

    public void setDdr(String ddr) {
        this.ddr = ddr;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
