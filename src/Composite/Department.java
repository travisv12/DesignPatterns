package Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printXML(StringBuilder xmlBuilder, int indent) {
        String indentSpace = " ".repeat(indent);
        xmlBuilder.append(indentSpace).append("<Department name=\"").append(name).append("\">\n");

        for (OrganizationComponent component : components) {
            component.printXML(xmlBuilder, indent + 2);
        }

        xmlBuilder.append(indentSpace).append("</Department>\n");
    }

    @Override
    public double getTotalSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : components) {
            totalSalary += component.getTotalSalary();
        }
        return totalSalary;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }
}