package FileHandler;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import VehicleClass.VehicleParent;


/*
OBJECTIVE: READ FROM .csv AND GIVE LIST DURING -create -b PROCESS
*/

public class AddtoDatabase {
	private static List<String> data;
	private static List<VehicleParent> listOfVehicles = new ArrayList<>();
	private static List<String> engNum = new ArrayList<>();
	private static List<Integer> indx = new ArrayList<>();
	private static int flag =0;

	// This method adds a vehicle to the list by taking the individual values
	private static void addToList(String values[]) {
		VehicleParent vehicle = new VehicleParent(values[0], Double.valueOf(values[1]), Double.valueOf(values[2]),
				Double.valueOf(values[3]), values[4], values[5]);
		listOfVehicles.add(vehicle);
	}

	// This method checks duplicate entry or not (returns 0 if not found and 1 if found)by taking engineNumber
	private static int present(String engineNumber)
	{
		int flag=0;
		if(engNum.size()>0){
        for (String string : engNum) {
			if(string.equals(engineNumber))
			{
			flag=1;
			break;
			}
		 }
	  }
		if(flag==1)
		return 1;
		else
		{
			if(listOfVehicles.size()>0)
			{
			for (VehicleParent v : listOfVehicles) {
				if(v.getEngineNumber().equals(engineNumber))
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			return 1;
			else
			return 0;
		}
		else
		return 0;
		}
	}

	// _____________Method to be called_______________//
	// _____________Requires Filename and number of records present in the
	// database______________//
	// _____________Returns the list of Vehicles to be inserted into
	// database________//
	
	// This method reads CSV and gives us a list of Vehicles
	public static List<VehicleParent> readFromCSV(String fileName, int num) {
		try {
			data = Files.readAllLines(Paths.get(fileName));
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
			return null;
		}
			for (int i = 0; i < num; i++) {
				String temp[] = data.get(i).split(",");
				engNum.add(temp[4]);
			}
			for (int i=num;i<data.size();i++) {
				String values[] = data.get(i).split(",");
				if(values.length==6)
				{
				int x = present(values[4]);
				if(x==0)
				AddtoDatabase.addToList(values);
				else
				{
					System.out.println("Duplicate entry found : "+data.get(i));
					indx.add(i);
				}
			   }
			   else
			   {
				   System.out.println("Incomplete inputs found at line number "+(1+i));
				   flag=1;
			   }
			}
			if(flag==0)
			{
			if(indx.size()>0){
			for (int i=0;i<indx.size();i++){
				data.remove(indx.get(i)-i);
			}
			try {
				Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
            }
			catch(Exception e)
			{
				e.getLocalizedMessage();
				return null;
			}
		  }
		  return listOfVehicles;
		}
		else
		{
			System.out.println("Found incomplete inputs so we are not gonna proceed any futher");
			return null;
		}
		
	}
}
