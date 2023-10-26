import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;

// new Exceptions:
//  DocumentException
//  URLException

public class FruttaPDF implements IFruttoFile{
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    throw new IOException("Cannot read from PDF file");
  }

  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException {
    
  }

}
