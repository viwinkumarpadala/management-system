/*
    Objective: During the -delete -b, the methods in this deletes both engineNumber entry and also respective vehicle entries.
*/

package FileHandler;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class DeleteFromFile {
    //Requires filename and number of records present in database //
    // returns set of enginenumbers to be deleted from database  //
    // function also deletes records from csv file //
    // and cleans the last lines of enginenumbers written //

    // This method reads from csv, deletes the engineNumbers written and their entries in the csv and returns the list of engineNumbers deleted
    public static Set<String> deleteFromFile(String fileName,int num) {
        List<String> data;
        List<String> engnum = new ArrayList<>();
        List<Integer> indx = new ArrayList<>();
        Set<String> engnum1 = new TreeSet<>();
        try {
            data = Files.readAllLines(Paths.get(fileName));
        }
        catch(Exception e)
        {
            e.getLocalizedMessage();
            return null;
        }
        int size = data.size();
        for(int i=num;i<size;i++)
        {
        engnum1.add(data.get(num));
        data.remove(num);
        }
        for (String string : data) {
            String temp[] = string.split(","); 
            engnum.add(temp[4]);
        }
        for (String string : engnum1) {
            int i=0;
            for (String string1 : engnum) {
                if(string1.equals(string))
                {
                indx.add(i);
                break;
                }
                i+=1;
            }
        }
       Collections.sort(indx);
       for(int i=0;i<indx.size();i++)
       data.remove(indx.get(i)-i);
        try {
            Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
            return engnum1;
        } 
      catch(Exception e)
      {
        e.getLocalizedMessage();
            return null;
      }
    }
}
