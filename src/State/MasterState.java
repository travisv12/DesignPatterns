package State;

public class MasterState implements CharacterState {
    private GameCharacter character;

    public MasterState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        System.out.println("You are a Master. No need to train anymore.");
    }

    @Override
    public void meditate() {
        System.out.println("You have achieved full wisdom.");
    }

    @Override
    public void fight() {
        System.out.println("You are undefeated. No need to fight.");
    }

    @Override
    public void displayStatus() {
        System.out.println("\n[Master Level] XP: " + character.getExperience() + " | HP: " + character.getHealth());
        System.out.println("Congratulations! You have reached Master Level.");
    }
}