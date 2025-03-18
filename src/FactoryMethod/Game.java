package FactoryMethod;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Map cityMap = game.createMap("city", 10, 5);
        Map wildernessMap = game.createMap("wilderness", 10, 5);

        System.out.println("City Map:");
        cityMap.display();

        System.out.println("\nWilderness Map:");
        wildernessMap.display();
    }

    public Map createMap(String type, int width, int height) {
        return switch (type.toLowerCase()) {
            case "city" -> new CityMap(width, height);
            case "wilderness" -> new WildernessMap(width, height);
            default -> throw new IllegalArgumentException("Invalid map type");
        };
    }
}
