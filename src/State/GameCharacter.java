package State;

public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(this);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public void gainExperience(int amount) {
        this.experience += amount;
        System.out.println(name + " gained " + amount + " XP!");
    }

    public void increaseHealth(int amount) {
        this.health = Math.min(100, this.health + amount);
        System.out.println(name + " gained " + amount + " HP!");
    }

    public void decreaseHealth(int amount) {
        this.health = Math.max(0, this.health - amount);
        System.out.println(name + " lost " + amount + " HP!");
        if (this.health == 0) {
            System.out.println(name + " has fainted! Game Over.");
            System.exit(0);
        }
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }

    public void displayStatus() {
        state.displayStatus();
    }
}