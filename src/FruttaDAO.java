import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class FruttaDAO {
    private static String prefixString = "jdbc:sqlite:";
    protected static Connection connection = null;

    static private String generateConnectionString(String pathname) {
        return prefixString + pathname;
    }

    static public void connectDatabase(String pathname) throws SQLException, IOException, ClassNotFoundException {
//        if (connection == null)
//            throw new IOException("Database connection has been already established");
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(generateConnectionString(pathname));
    }

    protected static void insert(String name, Stagione stagione, int eurkg) {
        insert(name, stagione.toString(), eurkg);
    }

    protected static void insert(String name, String stagionalita, int eurkg) {

    }

    protected static ArrayList<Frutta> selectAll() throws SQLException {
        ArrayList<Frutta> frutti = new ArrayList<Frutta>();
        String command = "SELECT nome,stagionalita,eurkg FROM frutti";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(command);

        while(rs.next()){


            frutti.add(new Frutta());
        }
        return frutti;
    }

    protected static ArrayList<Frutta> selectRange(int start, int end) throws SQLException {
        ArrayList<Frutta> frutti = new ArrayList<Frutta>();
        String command = String.format("SELECT id,nome,stagionalita,eurkg FROM frutti WHERE id >= %d AND id  <= %d", start,  end);

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(command);

        return frutti;
    }



}
