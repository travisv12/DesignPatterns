package FactoryMethod;

public class SwampTile implements Tile {
    public char getCharacter() { return 'S'; }
    public String getType() { return "swamp"; }
    public void action() { System.out.println("You step into a swamp. It's hard to walk!"); }
}
