import java.io.IOException;
import jakarta.xml.bind.JAXBException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import java.io.File;

public class FruttaODF implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    return null;
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

    SpreadSheet.createEmpty(model).saveAs(new File(filename));
  }
}

