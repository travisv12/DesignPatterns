package Builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }

    public void buildRAM() {
        computer.setRam(16);
    }

    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10 Home");
    }

    public Computer getComputer() {
        return this.computer;
    }
}

