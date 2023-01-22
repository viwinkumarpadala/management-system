package VehicleClass;

public class bike extends VehicleParent{
    
    private static final String fileName = "bike.csv";
    private static final String TableName = "bike";

    public static String getFilename() {
        return fileName;
    }

    public static String getTablename() {
        return TableName;
    }

    public bike(String model, double price, double onroadInterest, int milege, String engineNumber, String dateofMan) {
        super(model, price, onroadInterest, milege, engineNumber, dateofMan);
    }
}
