/*
 Objective: Simply delete all the records in the .csv folder
*/

package FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DeleteAllinFIle {
    // This method deletes everything from the appropriate .csv file
    public static void deleteAll(String fileName)
    {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            printWriter.println(" ");
            printWriter.close();
        } 
        catch(Exception e)
        {
        e.getLocalizedMessage();
        }
    }
}
