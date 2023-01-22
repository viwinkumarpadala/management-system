package VehicleClass;

public class auto extends VehicleParent{
    private static final String fileName = "auto.csv";
    private static final String TableName = "auto";

    public static String getFilename() {
        return fileName;
    }

    public static String getTablename() {
        return TableName;
    }

    public auto(String model, double price, double onroadInterest, int milege, String engineNumber, String dateofMan) {
        super(model, price, onroadInterest, milege, engineNumber, dateofMan);
    }
}
