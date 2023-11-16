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
    public static int create(Object obj) throws SQLException { return -1; }
    public static Object read(int id) throws SQLException { return null; }
    public static boolean update(Object obj) throws SQLException { return true; }
    public static boolean delete(Object obj) throws SQLException { return true; }
    public static ArrayList<Object> readAll() throws SQLException { return null; }

    public static void close() throws SQLException {
        if(connection == null) return;
        connection.close();
    }
}
