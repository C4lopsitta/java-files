import com.itextpdf.text.DocumentException;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

public final class FruttaSQL extends FruttaDAOImpl implements IFruttoFile {
    @Override
    public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException, DocumentException {
        throw new IOException("Unsupported");
    }

    @Override
    public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
        throw new IOException("Unsupported");
    }
}
