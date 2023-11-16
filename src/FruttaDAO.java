import java.sql.*;
import java.util.ArrayList;

public class FruttaDAO extends GenericDAO {
    public static int create(Object obj) throws SQLException {
        Frutta f = (Frutta)obj;
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO frutti VALUES(null, '" + f.getNome() + "', '" +
                        f.getStagionalita().toString() + "', " + f.getEurkg() + ");");
        ps.executeUpdate();
        ps = connection.prepareStatement("SELECT last_insert_rowid() AS id FROM frutti;");
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt("id");
    }
    public static Object read(int id) throws SQLException {
        if(connection == null) return null;
        String query = "SELECT * FROM frutti WHERE id = " + id + ";";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Frutta(rs.getInt("id"),
                          rs.getString("nome"),
                          Stagione.valueOf(rs.getString("stagionalita")),
                          rs.getInt("eurkg"));
    }
    public static boolean update(Object obj) throws SQLException {
        Frutta f = (Frutta)obj;
        if(connection == null) return true;
        String query = "UPDATE frutti SET nome = '" + f.getNome() +
                       "', stagionalita = '" + f.getStagionalita().toString() +
                       "', eurkg = " + f.getEurkg() + "WHERE id = " + f.getId() + ";";
        PreparedStatement ps = connection.prepareStatement(query);
        int rc =ps.executeUpdate();

        return rc != -1;
    }
    public static boolean delete(Object obj) throws SQLException {
        if(connection == null) return true;
        String query = "DELETE FROM frutti WHERE id = " + ((Frutta)obj).getId() + ";";
        PreparedStatement ps = connection.prepareStatement(query);
        int rc = ps.executeUpdate();

        return rc != -1;
    }
   public static ArrayList<Object> readAll() throws SQLException {
        if(connection == null) return null;
        String query = "SELECT * FROM frutti;";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Object> frutti = new ArrayList<>();
        while(rs.next()) {
            frutti.add(new Frutta(rs.getString("nome"),
                                  Stagione.valueOf(rs.getString("stagionalita")),
                                  rs.getInt("eurkg")));
        }
        return frutti;
    }
}
