package Flyweight;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    public Tile createTile() {
        int rand = random.nextInt(4);
        return switch (rand) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> new DefaultTile();
        };
    }
}