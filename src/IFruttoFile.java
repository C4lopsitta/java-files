import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import com.itextpdf.text.DocumentException;

public interface IFruttoFile{
  ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException, SQLException;
  void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException, DocumentException, SQLException;
}
