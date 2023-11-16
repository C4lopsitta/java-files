import com.itextpdf.text.DocumentException;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public final class FruttaSQL implements IFruttoFile {
    @Override
    public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException, DocumentException, SQLException {
        throw new IOException();

    }

    @Override
    public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException, SQLException {
        FruttaDAO.Connect(filename);
        ArrayList<Object> objects = FruttaDAO.readAll();
        for(Object f : objects){
            System.out.println(f.toString());
        }
        FruttaDAO.close();
        return null;
    }
}
