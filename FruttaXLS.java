import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import jakarta.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FruttaXML implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    ArrayList<Frutta> frutti = new ArrayList<Frutta>();

    return frutti;
  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException {
    Workbook wb = new HSSFWorkbook();
    Spreadsheet sheet = wb.createSheet("Frutti");

    int rowNum = 0;
    for(Frutta f : fruttiList) {
      Row row = sheet.createRow(rowNum);

      int colNum = 0;
      Cell cell = row.createCell(colNum++).setCellValue(f.getNome());
      cell = row.createCell(colNum++).setCellValue(f.getStagionalita().toString());
      cell = row.createCell(colNum++).setCellValue(f.getEurkg().toString());

      rowNum++;
    }

    FileOutputStream fw = new FileOutputStream(filename);
    wb.write(fw);
      
    fw.close();
  }
}
