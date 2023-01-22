/*
    Objective: Gives us idea about Aggregate Operations on Vehicles
*/

package VehicleClass;

import java.util.List;

public class VehicleStats {

    private String model;
    private int count;
    private double avgprice;
    private double onr;
    private double finalPrice;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(double avgprice) {
        this.avgprice = avgprice;
    }

    public double getOnr() {
        return onr;
    }

    public void setOnr(double onr) {
        this.onr = onr;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public VehicleStats(String model, int count, double avgprice, double onr, double finalPrice) {
        this.model = model;
        this.count = count;
        this.avgprice = avgprice;
        this.onr = onr;
        this.finalPrice = finalPrice;
    }

    private static double round_double(double value) {
        value *= 1000;
        value = (long) value;
        value = (double) value / 1000;
        return value;
    }

    // This method prints the stats of the list of vehicles given
    public static void printVehicleStats(List<VehicleStats> ls) {
        System.out.print(" ");
        for (int i = 1; i < 120; i++)
            System.out.print("_");
        System.out.println("");
        System.out.print(
                "|         Model         |     Number of units   |     On Road Interest  |      Avg Ex Price     |    Avg Final Price    |");
        System.out.println("");
        System.out.print("|");
        for (int i = 1; i <= 120; i++) {
            if (i % 24 == 0)
                System.out.print("|");
            else
                System.out.print("_");
        }
        for (VehicleStats vs : ls) {
            String temp = vs.getModel();
            System.out.println("");
            System.out.print("|");
            System.out.print(" " + temp);
            for (int i = temp.length() + 1; i < 23; i++)
                System.out.print(" ");
            temp = Integer.toString(vs.getCount());
            System.out.print("|");
            System.out.print(" " + temp);
            for (int i = temp.length() + 1; i < 23; i++)
                System.out.print(" ");
            temp = Double.toString(round_double(vs.getOnr()));
            System.out.print("|");
            System.out.print(" " + temp);
            for (int i = temp.length() + 1; i < 23; i++)
                System.out.print(" ");
            temp = Double.toString(round_double(vs.getAvgprice()));
            System.out.print("|");
            System.out.print(" " + temp);
            for (int i = temp.length() + 1; i < 23; i++)
                System.out.print(" ");
            temp = Double.toString(round_double(vs.getFinalPrice()));
            System.out.print("|");
            System.out.print(" " + temp);
            for (int i = temp.length() + 1; i < 23; i++)
                System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        System.out.print("|");
        for (int i = 1; i <= 120; i++) {
            if (i % 24 == 0)
                System.out.print("|");
            else
                System.out.print("_");
        }
        int units = 0;
        double avg_price = 0;
        double avg_fprice = 0;
        for (VehicleStats vs : ls) {
            units += vs.getCount();
            avg_price += vs.getCount()*vs.getAvgprice();
            avg_fprice += vs.getCount()*vs.getFinalPrice();
        }
        System.out.println("");
        System.out.print("|         Total         |");
        System.out.print(" " + units);
        for (int i = 1 + Integer.toString(units).length(); i < 23; i++)
            System.out.print(" ");
        System.out.print("|");
        for (int i = 0; i < 23; i++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(" " + round_double(avg_price));
        for (int i = 1 + Double.toString(round_double(avg_price)).length(); i < 23; i++)
            System.out.print(" ");
        System.out.print("|");
        System.out.print(" " + round_double(avg_fprice));
        for (int i = 1 + Double.toString(round_double(avg_fprice)).length(); i < 23; i++)
            System.out.print(" ");
        System.out.print("|");
        System.out.println("");
        System.out.print("|");
        for (int i = 1; i <= 120; i++) {
            if (i % 24 == 0)
                System.out.print("|");
            else
                System.out.print("_");
        }
    }
}
