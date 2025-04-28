package Flyweight;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    public Tile createTile() {
        int rand = random.nextInt(4);
        return switch (rand) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            default -> new DefaultTile();
        };
    }
}

