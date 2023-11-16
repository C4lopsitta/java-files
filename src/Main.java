import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;
import com.itextpdf.text.DocumentException;

public class Main{
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("USAGE: java Main inputFile outputFile\nIf using a database (SQLite) use extension \".db\"");
      System.exit(1);
    }

    String fileName = args[0];
    String outFileName = args[1];

    String inFileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
    String outFileExtension = outFileName.substring(outFileName.lastIndexOf('.') + 1);

    //try catch statement to catch possible exception in file opening
    try {
      IFruttoFile inFruttaFile;
      IFruttoFile outFruttaFile;

      inFruttaFile = switch (inFileExtension) {
        case "json" -> new FruttaJson();
        case "xml" -> new FruttaXML();
        case "csv" -> new FruttaCSV();
        case "xls" -> new FruttaXLS();
        case "xlsx" -> throw new IOException("Unsupported XLSX");
        case "ods" -> new FruttaODF();
        case "db" -> new FruttaSQL();
        default -> throw new IOException("File extension not supported");
      };

      outFruttaFile = switch (outFileExtension) {
        case "json" -> new FruttaJson();
        case "xml" -> new FruttaXML();
        case "csv" -> new FruttaCSV();
        case "xls" -> new FruttaXLS();
        case "xlsx" -> throw new IOException("Unsupported XLSX");
        case "ods" -> new FruttaODF();
        case "db" -> new FruttaSQL();
        case "pdf" -> new FruttaPDF();
        default -> throw new IOException("File extension not supported");
      };


      ArrayList<Frutta> frutti = inFruttaFile.readFile(fileName);

      outFruttaFile.writeFile(outFileName, frutti);

      IFruttoFile xls = new FruttaXLS();
      xls.writeFile("frutta.xls", frutti);

    } catch (IOException | JAXBException | DocumentException | SQLException e) {
      e.printStackTrace();
    }
  }
}

