package Composite;

public class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printXML(StringBuilder xmlBuilder, int indent) {
        String indentSpace = " ".repeat(indent);
        xmlBuilder.append(indentSpace).append("<Employee name=\"").append(name)
                .append("\" salary=\"").append(salary).append("\" />\n");
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }
}