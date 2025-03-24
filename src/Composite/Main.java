package Composite;

public class Main {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");
        Department financeDept = new Department("Finance");
        Department hrDept = new Department("Human Resources");
        Department itDept = new Department("IT Department");

        Employee emp1 = new Employee("Alice", 60000);
        Employee emp2 = new Employee("Bob", 55000);
        Employee emp3 = new Employee("Charlie", 70000);
        Employee emp4 = new Employee("David", 50000);
        Employee emp5 = new Employee("Emma", 48000);

        financeDept.add(emp1);
        financeDept.add(emp2);

        hrDept.add(emp3);

        itDept.add(emp4);
        itDept.add(emp5);

        headOffice.add(financeDept);
        headOffice.add(hrDept);
        headOffice.add(itDept);

        // Print total salary
        System.out.println("Total salary: $" + headOffice.getTotalSalary());

        // Print XML structure
        StringBuilder xmlBuilder = new StringBuilder();
        headOffice.printXML(xmlBuilder, 0);
        System.out.println("\nOrganizational Structure in XML:\n");
        System.out.println(xmlBuilder.toString());
    }
}