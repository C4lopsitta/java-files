import java.io.IOException;
import jakarta.xml.bind.JAXBException;
//TODO: Fix missing imports

public class FruttaODF implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {

  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException {
    DefaultTableModel model = new DefaultTableModel();

    String[] cols = {"Nome", "Stagionalità", "Eur/Kg"};

    for(String col: cols) {
      model.addColumn(col);
    }

    for(Frutta frutto : fruttiList) {
      model.addRow(frutto.toRow());
    }

    SpreadSheet.createSheet();
  }
}

