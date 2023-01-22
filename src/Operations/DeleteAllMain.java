/*
    Objective: Truncates table and deletes all entries in .csv
*/

package Operations;

import FileHandler.DeleteAllinFIle;
import VehicleClass.VehicleDBMS;

public class DeleteAllMain {
    // This method deletes everything from .csv and truncates the appropriate table
    public static void deleteall(String tableName, String fileName){
        //delete from .csv
        DeleteAllinFIle.deleteAll(fileName);
        //delete from dbms
        (new VehicleDBMS()).truncateTable(tableName);
        System.out.println("Deleted all entries sucessfully");
    }
}
