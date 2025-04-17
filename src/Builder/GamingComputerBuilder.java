package Builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    public void buildRAM() {
        computer.setRam(32);
    }

    public void buildHardDrive() {
        computer.setHardDrive("2 TB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4090");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    public Computer getComputer() {
        return this.computer;
    }
}

