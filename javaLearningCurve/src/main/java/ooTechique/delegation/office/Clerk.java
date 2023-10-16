package ooTechique.delegation.office;

import java.util.*;
import java.util.function.*;

public class Clerk implements Employee {

    private Printer printer;
    private int taskCount;
    private int relations  = 1;
    private List<String> hasPrintedList;

    public Clerk(Printer printer) {
        this.printer = printer;
        this.taskCount = 0;
        this.hasPrintedList = new ArrayList<String>();
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        printer.printDocument(document, this);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        return relations;
    }

    @Override
    public void addToHasPrintedList(String document) {
        hasPrintedList.add(document); 
    }
    @Override
    public List<String> getHasPrintedList() {
        List<String> copy = new ArrayList<String>(hasPrintedList);
        return copy;
    }
                
}
