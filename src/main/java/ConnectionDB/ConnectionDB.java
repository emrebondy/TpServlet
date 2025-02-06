package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/MasterAnnonce";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connect;

    private ConnectionDB () throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance()throws ClassNotFoundException {
        if (connect == null) {
            new ConnectionDB();
        }
        return connect;
    }
}
