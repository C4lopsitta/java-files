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
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

public class FruttaXLS implements IFruttoFile {
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    ArrayList<Frutta> frutti = new ArrayList<Frutta>();
    FileInputStream fis = new FileInputStream(filename);

    Workbook wb = new HSSFWorkbook(fis);
    Sheet sheet = wb.getSheetAt(0);
    
    int rowCount = sheet.getLastRowNum() + 1;

    for(int i = 1; i < rowCount; i++) {
      Row row = sheet.getRow(i);
      String nome = row.getCell(0).getStringCellValue();
      Stagione stagionalita = Stagione.valueOf(row.getCell(1).getStringCellValue());
      int eurkg = Integer.parseInt(row.getCell(2).getStringCellValue());
      frutti.add(new Frutta(nome, stagionalita, eurkg));
    }

    fis.close();
    return frutti;
  }

  public void writeFile(String filename, ArrayList<Frutta> fruttiList) throws IOException, JAXBException {
    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("Frutti");

    HSSFCellStyle headerStyle = (HSSFCellStyle) wb.createCellStyle();
    HSSFFont headerFont = (HSSFFont) wb.createFont();
    headerFont.setBold(true);
    headerStyle.setFont(headerFont);

    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue("Nome");
    cell = row.createCell(1);
    cell.setCellValue("Stagionalita");
    cell = row.createCell(2);
    cell.setCellValue("Eur/Kg");

    for(int i = 0; i < 3; i++)
      row.getCell(i).setCellStyle(headerStyle);

    int rowNum = 1;
    for(Frutta f : fruttiList) {
      row = sheet.createRow(rowNum);

      fruttaToRow(f, row);

      rowNum++;
    }
    for(int i = 0; i < 3; i++)
      sheet.autoSizeColumn(i);
  
    FileOutputStream fw = new FileOutputStream(filename);
    wb.write(fw);
      
    fw.close();
  }
  
  private void fruttaToRow(Frutta f, Row row) {
    int colNum = 0;
    Cell cell = row.createCell(colNum++);
    cell.setCellValue(f.getNome());
    cell = row.createCell(colNum++);
    cell.setCellValue(f.getStagionalita().toString());
    cell = row.createCell(colNum++);
    cell.setCellValue(f.getEurkg()+"");
  }
}
