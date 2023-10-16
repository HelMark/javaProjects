package ooTechique.delegation.office;

import java.util.*;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
    
    private Collection<Employee> employees;
    private ArrayList<Employee> employeesInList;
    private int taskCount;
    private int relations  = 1;

    private Employee clerkChoosen(ArrayList<Employee> employees) {
        Random random = new Random();
        int x = random.nextInt(employeesInList.size());
        return employees.get(x);
    }

    public Manager(Collection<Employee> employees) {
        if (employees.size() == 0) {
            throw new IllegalArgumentException("Employees cannot be null");
        }
        this.employees = employees;
        this.employeesInList = new ArrayList<Employee>(employees);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        Employee clerk = clerkChoosen(this.employeesInList);
        return clerk.doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        Employee clerk = clerkChoosen(this.employeesInList);
        clerk.printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        for (Employee employee : employees) {
            relations += employee.getResourceCount();
        }
        return relations;
    }

    @Override
    public void addToHasPrintedList(String document) {
        throw new UnsupportedOperationException("Manager does not have a print history");
    }

    @Override
    public List<String> getHasPrintedList() {
        throw new UnsupportedOperationException("Manager does not have a print history'");
    }
}
