import java.util.ArrayList;
import java.io.IOException;

public interface IFruttoFile{
  public ArrayList<Frutta> readFile(String filename) throws IOException;
  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException;
}
