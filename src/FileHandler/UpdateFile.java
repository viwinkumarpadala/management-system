/*
    Objective: This class has methods which update .csv files when -update -b is called (.csv updation)
*/

package FileHandler;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import VehicleClass.VehicleParent;

public class UpdateFile {
    private static List<VehicleParent> listOfVehicles = new ArrayList<>();
    private static List<Integer> indexes = new ArrayList<>();
    private static List<String> data;

    // This method adds vehicle to the list 
    private static void addToList(String line) {
        String values[] = line.split(",");
        VehicleParent vehicle = new VehicleParent(values[0], Double.valueOf(values[1]), Double.valueOf(values[2]),
                Double.valueOf(values[3]), values[4], values[5]);
        listOfVehicles.add(vehicle);
    }

    // This method stores the index which needs to be updated
    private static void update(String name, String refname, String Info, String newInfo)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        int indx = 0;
        if (name.equals("model") || name.equals("engineNumber") || name.equals("dateofMan")) {
            for (VehicleParent vehicle : listOfVehicles) {
                Object obj = vehicle;
                Class<?> cls = obj.getClass();
                Field f = cls.getDeclaredField(name);
                Field fo = cls.getDeclaredField(refname);
                f.setAccessible(true);
                fo.setAccessible(true);
                fo.setAccessible(true);
                if (refname.equals("model") || refname.equals("engineNumber") || refname.equals("dateofMan")) {
                    String temp = (String) fo.get(obj);
                    if (temp.equals(Info)) {
                        f.set(obj, newInfo);
                        indexes.add(indx);
                    }
                } else if (refname.equals("price") || refname.equals("onroadInterest") || refname.equals("milege")) {
                    Double temp = (double) fo.get(obj);
                    if (temp.equals(Double.valueOf(Info))) {
                        f.set(obj, newInfo);
                        indexes.add(indx);
                    }
                }
                indx += 1;
            }
        } else if (name.equals("price") || name.equals("onroadInterest") || name.equals("milege")) {
            for (VehicleParent vehicle : listOfVehicles) {
                Object obj = vehicle;
                Class<?> cls = obj.getClass();
                Field f = cls.getDeclaredField(name);
                Field fo = cls.getDeclaredField(refname);
                f.setAccessible(true);
                fo.setAccessible(true);
                fo.setAccessible(true);
                if (refname.equals("model") || refname.equals("engineNumber") || refname.equals("dateofMan")) {
                    String temp = (String) fo.get(obj);
                    if (temp.equals(Info)) {
                        f.set(obj, Double.valueOf(newInfo));
                        indexes.add(indx);
                    }
                } else if (refname.equals("price") || refname.equals("onroadInterest") || refname.equals("milege")) {
                    Double temp = (double) fo.get(obj);
                    if (temp.equals(Double.valueOf(Info))) {
                        f.set(obj, Double.valueOf(newInfo));
                        indexes.add(indx);
                    }
                }
                indx += 1;
            }
        }
    }

    // This method rewrites entire csv
    private static int WriteToFile(String fileName) {
        try {
            Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    // This method updates the vehicle in the buffer and writes back to the appropriate place in csv
    private static void UpdateValues() {
        for (Integer indx : indexes) {
            VehicleParent vehicle = listOfVehicles.get(indx);
            String temp_data = (vehicle.getModel() + "," + vehicle.getPrice() + "," + vehicle.getOnroadInterest() + ","
                    + vehicle.getMilege() + "," + vehicle.getEngineNumber() + "," + vehicle.getDateofMan());
            data.set(indx, temp_data);
        }
    }
    // _______________Method to be called________________//
    // ________________Requires fileName , Name of the attribute ,Ref attribute ,new
    // information(information to be updated) ,information(ref attribute
    // information) all attributes to be given in String datatype_________//
    // ________________Updates the csv files record on the given
    // information_______________________________//
    // ________________Returns 1 if successfull else returns 0_______________//

    // This method reads all lines from csv and directs to other updation methods above, which updates vehicle and also the csv
    public static int updateFile(String fileName, String name, String refname, String newInfo, String Info) {
        try {
            data = Files.readAllLines(Paths.get(fileName));
            for (String string : data) {
                UpdateFile.addToList(string);
            }
        } catch (Exception e) {
            return 0;
        }
        try {
            UpdateFile.update(name, refname, Info, newInfo);
        } catch (Exception e) {
            return 0;
        }
        UpdateFile.UpdateValues();
        if (UpdateFile.WriteToFile(fileName) == 1)
            return 1;
        else {
            if (UpdateFile.WriteToFile(fileName) == 1)
                return 1;
            else
                return 0;
        }
    }
}