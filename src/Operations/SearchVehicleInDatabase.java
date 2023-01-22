/*
    Objective: This is a director class which directs to search with or without order 
*/

package Operations;

import java.util.ArrayList;
import java.util.List;

import HelpOperations.Help;
import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;

public class SearchVehicleInDatabase {
    // This method takes arguments and directs to ordered searching or unordered searching
    public static void search(String args[], String tableName){
        VehicleDBMS vd = new VehicleDBMS();
        List<VehicleParent> ls = new ArrayList<>();
        if((args[2].equals("p")||args[2].equals("m")||args[2].equals("ori")||args[2].equals("mil")||args[2].equals("en")||args[2].equals("dom"))&&(args[3].equals("eq")||args[3].equals("gt")||args[3].equals("lt")))
        {
        if (args.length == 5){
            // search and give result without order
            ls = vd.searchVehiclebyID(Help.inShort(args[2]), Help.inShort(args[3]), args[4], tableName);    
        }
       else if (args.length == 6 && (args[5].equals("i")||args[5].equals("d")))
       {
            // search and give result with sorted order
            ls = vd.searchVehiclebyID(Help.inShort(args[2]), Help.inShort(args[3]), args[4], Help.inShort(args[5]), tableName);    
        }
        else
        {
            System.out.println("Entered invalid sorting order");
            System.out.println("Should enter i or d for increasing and decreasing order respectively");
        }
        VehicleParent.printListofVehicles(ls);
    }
    else
    {
        System.out.println("Entered invalid attribute or mode of operation");
    }
    }
}
