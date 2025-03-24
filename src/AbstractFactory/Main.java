package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        Button buttonA = factoryA.createButton("Click Me");
        TextField textFieldA = factoryA.createTextField("Enter Text");
        Checkbox checkboxA = factoryA.createCheckbox("Check Me");

        Button buttonB = factoryB.createButton("Press Me");
        TextField textFieldB = factoryB.createTextField("Input Text");
        Checkbox checkboxB = factoryB.createCheckbox("Select Me");

        System.out.println("\nStyle A:");
        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        System.out.println("\nStyle B:");
        buttonB.display();
        textFieldB.display();
        checkboxB.display();

        // Change text and display again
        System.out.println("\nChange text and display again:");
        buttonA.setText("New Text");
        buttonA.display();
    }
}