package Composite;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void printXML(StringBuilder xmlBuilder, int indent);
    public abstract double getTotalSalary();
    public abstract void add(OrganizationComponent component);
    public abstract void remove(OrganizationComponent component);
}