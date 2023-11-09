import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenericDAO {
    static Connection connection = null;
    static boolean Connect(String dbPath) throws SQLException {
        if(connection != null)
            return true;
        connection = DriverManager.getConnection(buildConnectionURL(dbPath));
        return false;
    }
    static String buildConnectionURL(String dbPath) {
        return "jdbc:sqlite:" + dbPath;
    }

    static int create(Object obj) { return -1; }
    static Object read(int id) { return null; }
    static boolean update(Object obj) { return true; }
    static boolean delete(Object obj) { return true; }
    static ArrayList<Object> readAll() { return null; }
}
