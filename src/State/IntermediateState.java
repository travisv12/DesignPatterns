package State;

public class IntermediateState implements CharacterState {
    private GameCharacter character;

    public IntermediateState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.gainExperience(15);
        if (character.getExperience() >= 50) {
            System.out.println(character.getExperience() + " XP reached! Leveling up to Expert.");
            character.setState(new ExpertState(character));
        }
    }

    @Override
    public void meditate() {
        character.increaseHealth(10);
    }

    @Override
    public void fight() {
        System.out.println("Intermediates cannot fight yet!");
    }

    @Override
    public void displayStatus() {
        System.out.println("\n[Intermediate Level] XP: " + character.getExperience() + " | HP: " + character.getHealth());
        System.out.println("Actions: Train, Meditate");
    }
}