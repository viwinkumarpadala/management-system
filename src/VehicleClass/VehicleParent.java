/*
    objective: Giving a brief structure about what a vehicle is and how it looks like and its methods
*/

package VehicleClass;

import java.util.ArrayList;
import java.util.List;


public class VehicleParent{
    private String model;
    private double price;
    private double onroadInterest;
    private double milege;
    private String engineNumber;
    private String dateofMan;
    
    public VehicleParent(String model, double price, double onroadInterest, double milege, String engineNumber,
        String dateofMan) {
        this.model = model;
        this.price = price;
        this.onroadInterest = onroadInterest;
        this.milege = milege;
        this.engineNumber = engineNumber;
        this.dateofMan = dateofMan;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getOnroadInterest() {
        return onroadInterest;
    }
    public void setOnroadInterest(double onroadInterest) {
        this.onroadInterest = onroadInterest;
    }
    public double getMilege() {
        return milege;
    }
    public void setMilege(int milege) {
        this.milege = milege;
    }
    public String getEngineNumber() {
        return engineNumber;
    }
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }
    public String getDateofMan() {
        return dateofMan;
    }
    public void setDateofMan(String dateofMan) {
        this.dateofMan = dateofMan;
    }

    public static double finalPrice(double price, double onroadInterest){
        price = price + (onroadInterest*price/100);
        return price;
    }

    // This method takes a list and directs to fancy printing(Box shaped) or list kind printing
    public static void printListofVehicles(List<VehicleParent> list)
    {
      if(list.size()<=25)
      print_nice(list); 
      else
      print_eff(list); 
    }

    // This method prints the list of vehicles in fancy printing(Box shaped)
    public static void print_nice(List<VehicleParent> list)
    {
        if(list.size()>=5)
        for(int i=0;i<139;i++)
        System.out.print("_");
        else
        for(int i=0;i<28*list.size()-1;i++)
        System.out.print("_");
        for(int i=0;i<list.size();i=i+5)
        {
            System.out.println("");
            List<VehicleParent> list1 = new ArrayList<>();
            for(int j=i;j<list.size() && j<i+5;j++)
            {
                list1.add(list.get(j));
            }
            for(int z=0;z<list1.size();z++)
            {
                System.out.print(" Model : "+list1.get(z).getModel());
                for(int x=27*z+9+list1.get(z).getModel().length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println("");
            for(int z=0;z<list1.size();z++)
            {
                Double d = list1.get(z).getPrice();
                String temp = Double.toString(d);
                System.out.print(" ExPrice : "+d);
                for(int x=27*z+11+temp.length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println("");
            for(int z=0;z<list1.size();z++)
            {
                Double d = list1.get(z).getOnroadInterest();
                String temp = Double.toString(d);
                System.out.print(" On Road Interest : "+d);
                for(int x=27*z+20+temp.length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
             System.out.println("");
            for(int z=0;z<list1.size();z++)
            {
                Double d = list1.get(z).getMilege();
                String temp = Double.toString(d);
                System.out.print(" Mileage : "+d);
                for(int x=(27*z)+11+temp.length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println("");
            for(int z=0;z<list1.size();z++)
            {
                System.out.print(" Engine Number : "+list1.get(z).getEngineNumber());
                for(int x=(27*z)+17+list1.get(z).getEngineNumber().length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println("");
            for(int z=0;z<list1.size();z++)
            {
                System.out.print(" DateofMan : "+list1.get(z).getDateofMan());
                for(int x=(27*z)+13+list1.get(z).getDateofMan().length();x<(z+1)*27;x++)
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println("");

            for(int z=1;z<=list1.size()*28;z++)
            {
            if(z%28==0)
            System.out.print("|");
            else
            System.out.print("_");
            }
            list1.clear();
        }
    }

    // This method prints the list of vehicles in Table format
    public static void print_eff(List<VehicleParent> list)
    {
        System.out.print(" ");
        for(int i=0;i<143;i++)
        System.out.print("_");
        System.out.println("");
        System.out.print("|         Model         |          Price        |    On Road Interest   |        Milege         |     Engine Number     |  Date of Manufacture  |");
         System.out.println("");
         System.out.print("|");
         for(int i=1;i<=144;i++)
         {
         if(i%24==0)
         System.out.print("|");
         else    
         System.out.print("_");
         }
         for (VehicleParent v : list) {
             String temp;
             System.out.println("");
             System.out.print("|");
             System.out.print(" "+v.getModel());
             for(int i=1+v.getModel().length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
             temp = Double.toString(v.getPrice());
             System.out.print(" "+temp);
             for(int i=1+temp.length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
             temp = Double.toString(v.getOnroadInterest());
             System.out.print(" "+temp);
             for(int i=1+temp.length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
             temp = Double.toString(v.getMilege());
             System.out.print(" "+temp);
             for(int i=1+temp.length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
             temp = v.getEngineNumber();
             System.out.print(" "+temp);
             for(int i=1+temp.length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
             temp = v.getDateofMan();
             System.out.print(" "+temp);
             for(int i=1+temp.length();i<23;i++)
             System.out.print(" ");
             System.out.print("|");
         }
         System.out.println("");
         System.out.print("|");
         for(int i=1;i<=144;i++)
         {
            if(i%24==0)
            System.out.print("|");
            else    
            System.out.print("_");
         }
    }

}
    