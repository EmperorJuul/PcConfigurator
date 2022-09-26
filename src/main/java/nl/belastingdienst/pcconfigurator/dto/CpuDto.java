package nl.belastingdienst.pcconfigurator.dto;

import javax.validation.constraints.NotNull;

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

    public CpuDto(Long id, String brand, String productLine, int generation, int tier, int modelNumber, String suffix, String socket, boolean hasIGpu) {
        this.id = id;
        this.brand = brand;
        this.productLine = productLine;
        this.generation = generation;
        this.tier = tier;
        this.modelNumber = modelNumber;
        this.suffix = suffix;
        this.socket = socket;
        this.hasIGpu = hasIGpu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public boolean isHasIGpu() {
        return hasIGpu;
    }

    public void setHasIGpu(boolean hasIGpu) {
        this.hasIGpu = hasIGpu;
    }
}
