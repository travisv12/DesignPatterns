package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Game diceGame = new DiceGame();
        diceGame.play(3); // You can test with any number of players
    }
}