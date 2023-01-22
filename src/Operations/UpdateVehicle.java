/*
    Objective: Based on user args, it directs to invoking the appropriate updation method 
*/


package Operations;

import FileHandler.UpdateFile;
import FileHandler.UpdateToDatabase;
import HelpOperations.Help;
import VehicleClass.VehicleDBMS;

public class UpdateVehicle {
    // This method directs to the appropriate updation function i.e csv updation or command line updation
    public static void update(String args[], String fileName, String tableName){
        if(args.length == 2){
            //update from csv
            UpdateVehicleinDatabase.updateVehicle(UpdateToDatabase.updateToDatabase(fileName, (new VehicleDBMS()).returnCount(tableName)), tableName);
        }
        
        else if(args.length == 7 && args[4].equals("where")){
            //command line updation
            //needs to update both database and .csv
            if((args[2].equals("p")||args[2].equals("m")||args[2].equals("ori")||args[2].equals("mil")||args[2].equals("dom"))&&(args[5].equals("p")||args[5].equals("m")||args[5].equals("ori")||args[5].equals("mil")||args[5].equals("en")||args[5].equals("dom")))
            {
            UpdateVehicleinDatabase.updateVehicle(args, tableName);
            UpdateFile.updateFile(fileName, Help.inShort(args[2]), Help.inShort(args[5]), args[3], args[6]);
            }
            else
            {
                System.out.println("Entered wrong attribute name");
            }
        }
        else{
            //printUpdateHelp
        }
    }
}
