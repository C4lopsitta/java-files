import java.sql.*;
import java.util.ArrayList;

public class FruttaDAOImpl {
    private static String prefixString = "jdbc:sqlite:";
    protected static Connection connection = null;

    static private String generateConnectionString(String pathname) {
        return prefixString + pathname;
    }

    static public void connectDatabase(String pathname) throws SQLException, ClassNotFoundException {
        if (connection != null)
            return;
//            throw new IOException("Database connection has been already established");
        connection = DriverManager.getConnection(generateConnectionString(pathname));
    }

    static public void closeConnection() throws SQLException {
        connection.close();
        connection = null;
    }

    protected static void insert(Frutta f) throws SQLException {
        insert(f.getNome(), f.getStagionalita(), f.getEurkg());
    }
    protected static void insert(String name, Stagione stagione, int eurkg) throws SQLException {
        insert(name, stagione.toString(), eurkg);
    }

    protected static void insert(String name, String stagionalita, int eurkg) throws SQLException {
        String command = String.format("INSERT INTO frutti VALUES(null, %s, %s, %d);", name, stagionalita, eurkg);
        Statement st = connection.createStatement();
    }

    protected static ArrayList<Frutta> selectAll() throws SQLException {
        ArrayList<Frutta> frutti = new ArrayList<Frutta>();
        String command = "SELECT nome,stagionalita,eurkg FROM frutti";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(command);

        while(rs.next()){
            String nome = rs.getString("nome");
            Stagione stagionalita = Stagione.valueOf(rs.getString("stagionalita").toUpperCase());
            int eurkg = rs.getInt("eurkg");
            frutti.add(new Frutta(nome,stagionalita,eurkg));
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
