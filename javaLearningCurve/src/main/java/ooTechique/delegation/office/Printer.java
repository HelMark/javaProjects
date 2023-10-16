package ooTechique.delegation.office;

import java.util.*;

public class Printer {

    public void printDocument(String document, Employee employee) {
        System.out.println(document);
        employee.addToHasPrintedList(document);
    }
    public List<String> getPrintHistory(Employee employee) {
        return employee.getHasPrintedList();
    }
}
