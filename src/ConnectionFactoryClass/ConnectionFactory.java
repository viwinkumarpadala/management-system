/*
    objective: TO give a new CONNECTION between DBMS and JAVA Code everytime the method of this class is called.
*/

package ConnectionFactoryClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "RBmysql@20";
    private static final String URL ="jdbc:mysql://localhost:3306/OOPS_project";

    // This method gives a new connection between Java and MYSQL
    public static Connection giveNewConnection(){
        Connection con = null;
        try {
            Properties connectionProperties = new Properties();
            connectionProperties.put("user",USERNAME);
            connectionProperties.put("password",PASSWORD);
            con = DriverManager.getConnection(URL,connectionProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
