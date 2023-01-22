/*
    Objective: Has the function print, which direct to the fancy print function by taking taking stats from VehicleStats
*/

package Operations;

import java.util.List;

import VehicleClass.VehicleDBMS;
import VehicleClass.VehicleStats;

public class PrintFinalAggregates {
    // This method prints the aggregate operations like count of each model, average price, average final price
    public static void print(String tableName){
        VehicleDBMS vd = new VehicleDBMS();
        List<VehicleStats> ls = vd.getVehicleStats(tableName);
        VehicleStats.printVehicleStats(ls);     
    }
}
