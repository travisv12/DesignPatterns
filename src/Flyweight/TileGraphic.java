package Flyweight;

import javafx.scene.image.Image;

public class TileGraphic {
    private final Image image;
    private final String description;

    public TileGraphic(String imagePath, String description) {
        this.image = new Image(imagePath);
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
