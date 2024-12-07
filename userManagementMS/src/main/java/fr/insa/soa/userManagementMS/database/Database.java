package fr.insa.soa.userManagementMS.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CON = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_058";
    private static final String DB_USER = "projet_gei_058";
    private static final String DB_PASSWORD = "Shaa9koh";

    private Database () {}

    public static Connection getDBConnection() {
        Connection con = null;
         try {
             Class.forName(DB_DRIVER);
         } catch (ClassNotFoundException e) {
        	 System.out.println("No driver class was found.");
        	 throw new RuntimeException(e);
         }
         try {
             con = DriverManager.getConnection(DB_CON, DB_USER, DB_PASSWORD);
             return con;
         } catch (SQLException e) {
             System.out.println("SQLException, Class Database, getDBConnection()" + e);
         }
         return con;
    }
}