import java.io.BufferedReader;
import jakarta.xml.bind.JAXBException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.DocumentException;

public final class FruttaJson implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException{
    ArrayList<Frutta> frutti = new ArrayList<Frutta>();
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);

    Type typeFrutta = new TypeToken<ArrayList<Frutta>>(){}.getType();

    Gson gson = new Gson();
    frutti = gson.fromJson(br, typeFrutta);

    return frutti;
  }

  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException, DocumentException {
    Gson gson = new Gson();
    String jason = gson.toJson(frutti);
    PrintWriter pr = new PrintWriter(filename);
    pr.print(jason);
    pr.close();
  }
}
