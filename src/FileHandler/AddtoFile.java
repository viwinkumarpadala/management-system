/*
    Objective: This one reads a vehicle from command line and adds to the .csv (If vehicle found, rejects)
*/

package FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import VehicleClass.VehicleParent;


public class AddtoFile {

    // This method checks if engineNumber is previously present or not during CommandLine Creation
    private static int checkinFile(String engineNumber,String fileName)
    {
        try
        {
         List<String> data = Files.readAllLines(Paths.get(fileName));
         String temp [];
         for(int i=0;i<data.size();i++)
         {
           temp = data.get(i).split(",");
           if(temp[4].equals(engineNumber))
           {
               return 0;
           }
         }
         return 1;
        }
        catch(Exception e)
        {
            e.getLocalizedMessage();
           return -1;
        }
      
    }
    // __________________Method to be called__________________//
    // __________________Requires an object of type vehicle and fileName(String)
    // ____________//
    // __________________Vehcile object must be made sure that it isn't already
    // present if alrready present it won't insert the new record________________//
    // __________________Returns 1 on successfull insertion of information into
    // file_________________//

    
    // This method takes a vehicle object and add it into the appropriate csv file
    public static int addToFile(String fileName, VehicleParent obj) {
        int a = AddtoFile.checkinFile(obj.getEngineNumber(),fileName);
        if(a==1)
        {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            String line = obj.getModel() + "," + obj.getPrice() + "," + obj.getOnroadInterest() + "," + obj.getMilege()
                    + "," + obj.getEngineNumber() + "," + obj.getDateofMan();
            printWriter.println(line);
            printWriter.close();
            return 1;
        } catch (Exception e) {
            return -1;
        }
        }
        else if(a==0)
        {
            System.out.println("vehicle to add aleady present");
            return 0;
        }
        else 
        {
             System.out.println("something went wrong");
             return -1;
        }
    }  
}
