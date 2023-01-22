/*
    Objective: This is a director class which directs and calls the appropriate delete method.
*/

package Operations;

import java.util.Set;

import FileHandler.DeleteFromFile;
import FileHandler.DeleteinFile;
import HelpOperations.Help;
import VehicleClass.VehicleDBMS;

public class DeleteVehicleFromDatabase {
    // This method directs to the appropriate delete method i.e. csv or command line
    public static void delete(String args[], String fileName, String tableName){
        VehicleDBMS vd = new VehicleDBMS();
        if(args.length == 2){
            //read from csv and delete from both 
            Set<String> temp = DeleteFromFile.deleteFromFile(fileName, vd.returnCount(tableName));
            //delete from database   
            vd.deleteVehicle(temp, tableName);
            System.out.println("Current Count: " + vd.returnCount(tableName));
        }
        else if(args.length == 4){
            if(args[2].equals("p")||args[2].equals("m")||args[2].equals("ori")||args[2].equals("mil")||args[2].equals("en")||args[2].equals("dom"))
            {
            //no return while deleting from file
            DeleteinFile.deleteinFile(fileName, Help.inShort(args[2]), args[3]);
            //no return while deleting from database
            vd.deleteVehicleFromAttribute(Help.inShort(args[2]), args[3], tableName);
            System.out.println("Current Count: " + vd.returnCount(tableName));
            }
            else
            {
                System.out.println("Entered wrong attribute name");
            }
        }
    }
    
}