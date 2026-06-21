package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    public static Connection getConnection()
    {
        try
        {
            Class.forName(
            "com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con =

            DriverManager.getConnection(

            "jdbc:sqlserver://localhost\\SQLEXPRESS;"
            + "databaseName=LeaveManagementSystem;"
            + "user=test;"
            + "password=1234;"
            + "encrypt=true;"
            + "trustServerCertificate=true;");

            return con;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
}