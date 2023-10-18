import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;

public interface IFruttoFile{
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException;
  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException;
}
