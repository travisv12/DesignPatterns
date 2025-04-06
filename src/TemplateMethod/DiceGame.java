package TemplateMethod;

import java.util.Random;

public class DiceGame extends Game {
    private int[] playerScores;
    private int numberOfPlayers;
    private int winningScore = 20;
    private int winner = -1;
    private Random random = new Random();
    private int turn = 0;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.playerScores = new int[numberOfPlayers];
        System.out.println("Dice Game initialized with " + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Current turn: " + ++turn);
        int roll = random.nextInt(6) + 1;
        playerScores[player] += roll;
        System.out.println("Player " + (player + 1) + " rolls a " + roll + " (Total: " + playerScores[player] + ")");

        if (playerScores[player] >= winningScore && winner == -1) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + (winner + 1) + " wins the game with " + playerScores[winner] + " points!");
    }
}