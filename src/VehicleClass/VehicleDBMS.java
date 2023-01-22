/*
    objective: Implementing CRUD operations on Vehicles through DBMS
*/

package VehicleClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ConnectionFactoryClass.ConnectionFactory;
import HelpOperations.Help;

public class VehicleDBMS implements VehicleDBMSMethods{
    // This method takes a vehicle object and adds it into the appropriate DBMS Table
    public void createVehicle(VehicleParent vehicle, String TableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "insert into " + TableName + " values(?, ?, ?, ?, ?, ?)"; 
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, vehicle.getModel());
            stmt.setDouble(2, vehicle.getPrice());
            stmt.setDouble(3, vehicle.getOnroadInterest());
            stmt.setDouble(4, vehicle.getMilege());
            stmt.setString(5, vehicle.getEngineNumber());
            stmt.setString(6, vehicle.getDateofMan());
            int k = stmt.executeUpdate();
            System.out.println(k + " rows have been affected");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
    }

    // This method takes the tablename and returns all the entries in the respective tablename in the form of a list
    public List<VehicleParent> printVehicleContent(String TableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "select * from " + TableName;
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            List<VehicleParent> ls = new ArrayList<VehicleParent>();
            while(rs.next()){
                VehicleParent stud = new VehicleParent(rs.getString("model"), rs.getDouble("price"), rs.getDouble("onroadInterest"), rs.getInt("milege"), rs.getString("engineNumber"), rs.getString("dateofMan"));
                ls.add(stud);
            }
            con.close();
            return ls;
        }catch(Exception e){
            e.getLocalizedMessage();
            return null;
        }
    }

    // This method returns the number of vehicles in the specified table
    public int returnCount(String tableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "select count(*) from " + tableName;
        ResultSet rs;
        int c = 0;
        try(PreparedStatement stmt = con.prepareStatement(query)){
            rs = stmt.executeQuery(query);
            rs.next();
            c = rs.getInt(1);
            rs.close();
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
        return (c);
    }

    // This method takes a set of engineNumbers and deletes them from the appropriate vehicle DBMS table
    public void deleteVehicle(Set<String> EngineNumber, String tableName){
        Connection con = ConnectionFactory.giveNewConnection();
        for (String string : EngineNumber) {
            String query = "delete from " + tableName + " where engineNumber =  ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, string);
            stmt.executeUpdate();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
        }
    }

    // This method deletes the vehicle from DBMS Table purely on engineNumber
    public void deleteVehicle(String EngineNumber, String tableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "delete from " + tableName + " where engineNumber =  " + "?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, EngineNumber);
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
    }

    // This method deletes the vehicle from appropriate vehicle DBMS table
    public void deleteVehicleFromAttribute(String Attribute, String data, String tableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "delete from " + tableName + " where " + Attribute + " =  ?" ;
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, data);
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
    }

    // This method takes arguments and update the entry in the appropriate table
    public void updateVehicle(String args[], String tableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "update " + tableName + " set " + Help.inShort(args[2])  + " = ?" +  " where " + Help.inShort(args[5]) +  " = " + "?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, args[3]);
            stmt.setString(2, args[6]);
           int k = stmt.executeUpdate();
           System.out.println(k + " rows have been updated");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }
    }

    // This method searches the vehicles and returns list based on attribute
    //search with order
    public List<VehicleParent> searchVehiclebyID(String attribute, String mode, String val, String order, String tableName){
        List<VehicleParent>  c = new ArrayList<VehicleParent>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query;
        if(attribute.equals("engineNumber") || attribute.equals("dateofMan") || attribute.equals("model")){
            String temp;
            if(mode.equals("=")){
                temp = "'%" + val + "%'";
                val = temp;
                mode = "like"; 
            }
            else{
                temp = "'" + val + "'";
                val = temp;
            }
        }
        query = "select * from " + tableName + " where " + attribute + " " + mode + " " + val + " order by " + attribute + " " + order;
        try(PreparedStatement st = con.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                VehicleParent tempcar = new VehicleParent(rs.getString("model"), rs.getDouble("price"), rs.getDouble("onroadInterest"), rs.getDouble("milege"), rs.getString("engineNumber"), rs.getString("dateofMan"));
                c.add(tempcar);
            }
            con.close();
            return c;
        }
    
        catch(SQLException e){
            System.out.println("Cant search numeric value with a String");
            e.getLocalizedMessage();
        }
    
        return c;
    }

    //This method searches the vehicles and returns list based on attribute
    //search without order
    public List<VehicleParent> searchVehiclebyID(String attribute, String mode, String val, String tableName){
        List<VehicleParent>  c = new ArrayList<VehicleParent>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query;
        if(attribute.equals("engineNumber") || attribute.equals("dateofMan") || attribute.equals("model")){
            String temp;
            if(mode.equals("=")){
                temp = "'%" + val + "%'";
                val = temp;
                mode = "like"; 
            }
            else{
                temp = "'" + val + "'";
                val = temp;
            }
        }
        query = "select * from " + tableName + " where " + attribute + " " + mode + " " + val;
        try(PreparedStatement st = con.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                VehicleParent tempcar = new VehicleParent(rs.getString("model"), rs.getDouble("price"), rs.getDouble("onroadInterest"), rs.getDouble("milege"), rs.getString("engineNumber"), rs.getString("dateofMan"));
                c.add(tempcar);
            }
            con.close();
            return c;
        }
    
        catch(SQLException e){
            System.out.println("Cant search numeric value with a String");
            e.getLocalizedMessage();
        }
    
        return c;
    }

    // This method takes one attribute and returns list from it
    public List<VehicleParent> sortVehiclebyAttribute(String attribute, String order, String tableName){
        List<VehicleParent>  c = new ArrayList<VehicleParent>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query = "select * from " + tableName + " order by " + attribute + " " + order;
        try(PreparedStatement st = con.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                VehicleParent tempcar = new VehicleParent(rs.getString("model"), rs.getDouble("price"), rs.getDouble("onroadInterest"), rs.getDouble("milege"), rs.getString("engineNumber"), rs.getString("dateofMan"));
                c.add(tempcar);
            }
            con.close();
            return c;
        }
    
        catch(SQLException e){
            e.getLocalizedMessage();
        }
        return c;
    }

    // This method gives us a list of VehicleStats which has details about aggregates
    public List<VehicleStats> getVehicleStats(String TableName){
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "select distinct model as ModelName, count(*) as NumberOfVehicles, avg(price) as AvgExPrice, avg(onroadInterest) as OnroadInterest, avg(price) + (avg(onroadInterest)*avg(price)/100) as AvgFinalPrice from " + TableName + " group by model";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            List<VehicleStats> ls = new ArrayList<VehicleStats>();
            while(rs.next()){
                VehicleStats v = new VehicleStats(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                ls.add(v);
            }
            con.close();
            return ls;
        }catch(Exception e){
            e.getLocalizedMessage();
            return null;
        }
    }

    // This method truncates the given table contents
    @Override
    public void truncateTable(String TableName) {
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "truncate table " + TableName;
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("Table " + TableName + " has been truncated");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        } 
    }
}
