import java.io.BufferedReader;
import jakarta.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FruttaCSV implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    ArrayList<Frutta> frutti = new ArrayList<Frutta>();

    FileReader fileIn = new FileReader(filename);  
    BufferedReader br = new BufferedReader(fileIn);
    //out of cycle read
    String line = br.readLine();
    while(line != null){
      frutti.add(new Frutta(line));
      line = br.readLine();
    }
    br.close();

    return frutti;
  }

  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException {
    PrintWriter pr = new PrintWriter(filename);
    for(Frutta f : frutti){
      pr.println(f.toCSV());
    }
    pr.close();
  }
}
