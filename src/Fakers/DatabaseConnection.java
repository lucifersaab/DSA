package Fakers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public Connection getConnection() {
            Connection connection = null;

            String connectionString = "jdbc:sqlserver://LUCI\\SQLEXPRESS;databaseName=Gymkhana;integratedSecurity=true;";

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                connection = DriverManager.getConnection(connectionString);

            }catch(Exception e){
                e.printStackTrace();
                e.getCause();
            }
        return connection;
        }
    }

