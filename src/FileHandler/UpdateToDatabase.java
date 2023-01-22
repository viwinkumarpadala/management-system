package FileHandler;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import VehicleClass.VehicleParent;

public class UpdateToDatabase {
    private static List<String> data;
    private static List<String> listOfengineNumbers = new ArrayList<>();
    private static List<VehicleParent> listOfVehicles = new ArrayList<>();
    private static List<Integer> indexes = new ArrayList<>();
    private static int flag = 0;

    // This method adds vehicle to the list
    private static void addToList(String line,int line_num,int num) {
        if(line_num<num)
        {
            String values[] = line.split(",");
            listOfengineNumbers.add(values[4]); 
        }
        else
        {
        String values[] = line.split(",");
        if(values.length==6)
        {
        VehicleParent vehicle = new VehicleParent(values[0], Double.valueOf(values[1]), Double.valueOf(values[2]),
                Double.valueOf(values[3]), values[4], values[5]);
        listOfVehicles.add(vehicle);
        }
        else
        {
            System.out.println("Incomplete inputs found at line : "+(line_num+1));
            flag  = 1;
        }
       }
    }

    // __________________Method to be called____________________________//
    // __________________Returns list of Vehicles to be updated to
    // database____________________//
    // __________________Requires fileName and number of records already present in
    // database________________//

    // This method finds the attributes and returns the list which needs to be updated
    public static List<VehicleParent> updateToDatabase(String fileName, int num) {
        try {
            data = Files.readAllLines(Paths.get(fileName));
           }
           catch(Exception e)
           {
               e.getLocalizedMessage();
               return null;
           }
           for (int i=0;i<data.size();i++) {
            UpdateToDatabase.addToList(data.get(i),i,num);
            }

            if(flag ==0)
            {
                for (int x = 0; x < listOfVehicles.size(); x++) {
                    for (int y = 0; y < listOfengineNumbers.size(); y++) {
                        if (listOfVehicles.get(x).getEngineNumber().equals(listOfengineNumbers.get(y))){
                            indexes.add(y);
                        }
                    }
                }
                Collections.sort(indexes);
                for(int i=0;i<indexes.size();i++)
                {
                    data.remove(indexes.get(i)-i);
                }
            try {
                Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
                return listOfVehicles;
            } 
            catch(Exception e)
            {
                e.getLocalizedMessage();
                return null;
            }
            }
            else
            {
                System.out.println("Found out incomplete inputs not gonna proceed any further");
                return null;
            }
        
    } 
}