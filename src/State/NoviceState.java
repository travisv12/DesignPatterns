package State;

public class NoviceState implements CharacterState {
    private GameCharacter character;

    public NoviceState(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.gainExperience(10);
        if (character.getExperience() >= 20) {
            System.out.println(character.getExperience() + " XP reached! Leveling up to Intermediate.");
            character.setState(new IntermediateState(character));
        }
    }

    @Override
    public void meditate() {
        System.out.println("Novices cannot meditate yet!");
    }

    @Override
    public void fight() {
        System.out.println("Novices cannot fight yet!");
    }

    @Override
    public void displayStatus() {
        System.out.println("\n[Novice Level] XP: " + character.getExperience() + " | HP: " + character.getHealth());
        System.out.println("Actions: Train");
    }
}