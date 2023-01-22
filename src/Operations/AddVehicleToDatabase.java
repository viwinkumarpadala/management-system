/*
    Objective: It takes a list from .csv and directs to adding database, one at a time
*/


package Operations;

import java.util.List;

import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;

public class AddVehicleToDatabase {
    // This method takes a list of vehicles from AddtoDatabase.readfromCSV and adds it to the database via createVehicle function
    public static void addVehicle(List<VehicleParent> list, String tableName){
        if(list!=null)
        {
        for (VehicleParent v : list){
            (new VehicleDBMS()).createVehicle(v, tableName);
        }
    }
    }
}
