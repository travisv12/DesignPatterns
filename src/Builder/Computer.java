package Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private List<String> accessories = new ArrayList<>();

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Computer Configuration:\n");
        sb.append("Processor: ").append(processor).append("\n");
        sb.append("RAM: ").append(ram).append(" GB\n");
        sb.append("Hard Drive: ").append(hardDrive).append("\n");
        sb.append("Graphics Card: ").append(graphicsCard).append("\n");
        sb.append("Operating System: ").append(operatingSystem).append("\n");
        if (!accessories.isEmpty()) {
            sb.append("Accessories:\n");
            for (String acc : accessories) {
                sb.append("- ").append(acc).append("\n");
            }
        }
        return sb.toString();
    }
}
