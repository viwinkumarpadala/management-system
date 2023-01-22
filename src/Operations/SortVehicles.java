/*
    Objective: Sorts the list from DBMS and directs it to fancy prints 
*/

package Operations;

import java.util.List;

import HelpOperations.Help;
import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;

public class SortVehicles {
    // This method sorts on attribute and directs to printing function
    public static void sort(String args[], String tableName) {
        if (args[2].equals("p") || args[2].equals("m") || args[2].equals("ori") || args[2].equals("mil")
                || args[2].equals("en") || args[2].equals("dom")) {
            if (args[3].equals("i") || args[3].equals("d")) {
                List<VehicleParent> ls = (new VehicleDBMS()).sortVehiclebyAttribute(Help.inShort(args[2]),
                        Help.inShort(args[3]), tableName);
                if (ls != null) {
                    VehicleParent.printListofVehicles(ls);
                }
            } else {
                System.out.println("Entered invalid sorting order");
                System.out.println("Should enter i or d for increasing and decreasing order respectively");
            }
        } else {
            System.out.println("Entered invalid attribute");
        }
    }
}
