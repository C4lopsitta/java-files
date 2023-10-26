import java.io.IOException;
import jakarta.xml.bind.JAXBException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.MutableCell;
import java.io.File;

public class FruttaODF implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    SpreadSheet spreadsheet = SpreadSheet.createFromFile(new File(filename));
    Sheet sheet = spreadsheet.getSheet(0);
    int nRow = sheet.getRowCount();
    int nCol = sheet.getColumnCount();

    MutableCell cellName = null;
    MutableCell cellStagionalita = null;
    MutableCell cellEurkg = null;

    ArrayList<Frutta> frutti = new ArrayList<Frutta>();

    for(int i = 1; i < nRow; i++) {
      cellName = sheet.getCellAt(nCol-3,  i);
      cellStagionalita = sheet.getCellAt(nCol-2, i);
      cellEurkg = sheet.getCellAt(nCol-1, i);

      String name = (cellName != null) ? cellName.getTextValue() : "";
      Stagione stagionalita = (cellStagionalita != null) ? Stagione.valueOf(cellStagionalita.getTextValue()) : Stagione.UNDEFINED;
      int eurkg = (cellEurkg != null) ? Integer.parseInt(cellEurkg.getTextValue()) : 0;

      frutti.add(new Frutta(name, stagionalita, eurkg));
    }

    return frutti;
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

