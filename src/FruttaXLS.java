import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import jakarta.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.*;

public class FruttaXLS implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    ArrayList<Frutta> frutti = new ArrayList<Frutta>();

    return frutti;
  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException {
    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("Frutti");

    int rowNum = 0;
    for(Frutta f : fruttiList) {
      Row row = sheet.createRow(rowNum);

      int colNum = 0;
      Cell cell = row.createCell(colNum++);
      cell.setCellValue(f.getNome());
      cell = row.createCell(colNum++);
      cell.setCellValue(f.getStagionalita().toString());
      cell = row.createCell(colNum++);
      cell.setCellValue(f.getEurkg()+"");

      rowNum++;
    }
    for(int i = 0; i < 3; i++)
      sheet.autoSizeColumn(i);
  
    FileOutputStream fw = new FileOutputStream(filename);
    wb.write(fw);
      
    fw.close();
  }
}
