/*
    Objective: All the Operations possible on Vehicle is given here. 
*/


package VehicleClass;

import java.util.List;
import java.util.Set;

// This interface has all the Database methods which are required for Vehicle Management Database
public interface VehicleDBMSMethods{
    public void createVehicle(VehicleParent vehicle, String TableName);
    List<VehicleParent> printVehicleContent(String TableName);
    int returnCount(String tableName);
    void deleteVehicle(Set<String> EngineNumber, String tableName);
    void deleteVehicleFromAttribute(String Attribute, String data, String tableName);
    void updateVehicle(String args[], String tableName);
    List<VehicleParent> searchVehiclebyID(String attribute, String mode, String val, String tableName);
    List<VehicleParent> sortVehiclebyAttribute(String attribute, String order, String tableName);
    List<VehicleStats> getVehicleStats(String TableName);
    void truncateTable(String TableName);
}
