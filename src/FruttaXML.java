import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import com.itextpdf.text.DocumentException;

public class FruttaXML implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    JAXBContext context = JAXBContext.newInstance(Frutti.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    FileInputStream fis = new FileInputStream(filename);

    Frutti frutti = (Frutti)unmarshaller.unmarshal(fis);

    return frutti.getFrutti();
  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException, DocumentException {
    Frutti frutti = new Frutti(fruttiList);

    JAXBContext context = JAXBContext.newInstance(Frutti.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    FileWriter fw = new FileWriter(filename);
    
    marshaller.marshal(frutti, fw);
      
    fw.close();
  }
}
