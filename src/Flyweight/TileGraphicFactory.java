package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> graphics = new HashMap<>();

    public static TileGraphic getTileGraphic(String type) {
        TileGraphic graphic = graphics.get(type);
        if (graphic == null) {
            switch (type) {
                case "road" -> graphic = new TileGraphic("road.png", "A simple road.");
                case "forest" -> graphic = new TileGraphic("forest.png", "Dense forest.");
                case "building" -> graphic = new TileGraphic("building.png", "Urban building.");
                case "swamp" -> graphic = new TileGraphic("swamp.png", "Muddy swamp.");
                case "water" -> graphic = new TileGraphic("water.png", "A water body.");
                default -> graphic = new TileGraphic("default.png", "Unknown terrain.");
            }
            graphics.put(type, graphic);
        }
        return graphic;
    }
}
