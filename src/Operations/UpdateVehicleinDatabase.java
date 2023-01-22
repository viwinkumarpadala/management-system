/*
    Objective: This methods are invoked when Command Line Upation Happens and also helps in .csv updation!
*/

package Operations;

import java.util.List;

import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleParent;

public class UpdateVehicleinDatabase {
    private static VehicleDBMS vd = new VehicleDBMS();
    // This method reads from csv, and through the list of vehicles, deletes entry and re-enters new entry
    public static void updateVehicle(List<VehicleParent> list, String tableName){
       if(list!=null)
       { 
       for (VehicleParent v : list) {
           vd.deleteVehicle(v.getEngineNumber(), tableName);
       }
       for (VehicleParent v : list) {
           vd.createVehicle(v, tableName);
       }
       System.out.println("Updated "+list.size()+" rows");
      }
    }

    // This method directly updates the Vehicle DBMS Table
    public static void updateVehicle(String args[], String tableName){
        vd.updateVehicle(args, tableName);
    }
}

