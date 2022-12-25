package com.wqf.extend.exercise;

public class Computer {
    private String CPU;
    private String memory;
    private String hardDisk;

    public Computer(String CPU, String memory, String hardDisk) {
        this.setCPU(CPU);
        this.setHardDisk(hardDisk);
        this.setMemory(memory);
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getDetails() {
        return this.getCPU() + this.getHardDisk() + this.getMemory();
    }
}
