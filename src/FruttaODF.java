import java.io.IOException;
import jakarta.xml.bind.JAXBException;

public class FruttaODF implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {

  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException {
    Frutti frutti = new Frutti(fruttiList);

  }
}

