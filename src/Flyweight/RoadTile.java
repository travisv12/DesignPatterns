package Flyweight;

public class RoadTile implements Tile {
    public char getCharacter() { return 'R'; }
    public String getType() { return "road"; }
    public void action() { System.out.println("You walk along a road."); }
}