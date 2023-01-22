/*
    Objective: This class directs to what Method is being called during creation 
*/

package Operations;

import FileHandler.AddtoDatabase;
import FileHandler.AddtoFile;
import HelpOperations.Help;
import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;

public class CreateVehicle {
    // This method directs to the appropriate creation method i.e csv creation or command line creation
    public static int create(String args[], String FileName, String TableName){
        VehicleDBMS vd = new VehicleDBMS();
        if(args.length == 2){
           // add from csv
           AddVehicleToDatabase.addVehicle(AddtoDatabase.readFromCSV(FileName, vd.returnCount(TableName)), TableName);
           System.out.println("Current Count: " + vd.returnCount(TableName));
        }
        else if(HelpOperations.Help.checkCreationArguments(args) == 1){
            //add to dbms
            VehicleParent v = new VehicleParent(args[2], Double.valueOf(args[3]), Double.valueOf(args[4]), Double.valueOf(args[5]), args[6], args[7]);
            vd.createVehicle(v, TableName);
            //add to csv
            int res = AddtoFile.addToFile(FileName, v);
            if(res == 1){
                System.out.println(TableName + " " + v.getModel() + " has been inserted");
            }
            System.out.println("Current Count: " + vd.returnCount(TableName));
        }
        else{
            System.out.println("No of inputs not sufficient: \n");
            Help.printCreateHelp();
        }
        return 0;
    }
}
