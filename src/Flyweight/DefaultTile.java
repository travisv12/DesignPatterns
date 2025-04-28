package Flyweight;

public class DefaultTile implements Tile {
    public char getCharacter() { return 'D'; }
    public String getType() { return "default"; }
    public void action() { System.out.println("You enter a default tile."); }
}

