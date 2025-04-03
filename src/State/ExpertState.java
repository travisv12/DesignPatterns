package State;

public class ExpertState implements CharacterState {
    private GameCharacter character;

    public ExpertState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.gainExperience(20);
        if (character.getExperience() >= 100) {
            System.out.println(character.getExperience() + " XP reached! Leveling up to Master.");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void meditate() {
        character.increaseHealth(15);
    }

    @Override
    public void fight() {
        character.gainExperience(30);
        character.decreaseHealth(20);
        if (character.getExperience() >= 100) {
            System.out.println(character.getExperience() + " XP reached! Leveling up to Master.");
            character.setState(new MasterState(character));
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("\n[Expert Level] XP: " + character.getExperience() + " | HP: " + character.getHealth());
        System.out.println("Actions: Train, Meditate, Fight");
    }
}