package nl.belastingdienst.pcconfigurator.dto;

import nl.belastingdienst.pcconfigurator.Model.Pc;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class GpuDto {

    @NotNull
    private long id;
    private String brand;
    private String productLine;
    private int generation;
    private int modelNumber;
    private String suffix;
    private int vram;

    public GpuDto(long id, String brand, String productLine, int generation, int modelNumber, String suffix, int vram) {
        this.id = id;
        this.brand = brand;
        this.productLine = productLine;
        this.generation = generation;
        this.modelNumber = modelNumber;
        this.suffix = suffix;
        this.vram = vram;
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

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }
}
