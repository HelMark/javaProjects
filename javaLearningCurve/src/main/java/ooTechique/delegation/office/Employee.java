package ooTechique.delegation.office;

import java.util.*;
import java.util.function.*;

public interface Employee {

    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2);
    public void printDocument(String document);
    public int getTaskCount();
    public int getResourceCount();

    public void addToHasPrintedList(String document);
    public List<String> getHasPrintedList();

}
