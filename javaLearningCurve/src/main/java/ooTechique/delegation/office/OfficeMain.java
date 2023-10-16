package ooTechique.delegation.office;
import java.util.*;
public class OfficeMain {
    
    public static void main(String[] args) {
         Printer printer = new Printer();
		 Clerk clerk1 = new Clerk(printer);
        
        printer.printDocument("dokument1", clerk1);
		printer.printDocument("dokument2", clerk1);
        System.out.println(printer.getPrintHistory(clerk1).size());
        printer.getPrintHistory(clerk1).remove("dokument1");
        System.out.println(printer.getPrintHistory(clerk1).size());

        Manager manager = new Manager(Arrays.asList(clerk1));
        Manager topManager = new Manager(Arrays.asList(manager));
        System.out.println(topManager.getResourceCount());


    }
}   
