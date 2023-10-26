import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.io.FileOutputStream;

// new Exceptions:
//  DocumentException
//  MalformedURLException

public class FruttaPDF implements IFruttoFile{
  public ArrayList<Frutta> readFile(String filename) throws IOException, JAXBException {
    throw new IOException("Cannot read from PDF file");
  }

  public void writeFile(String filename, ArrayList<Frutta> frutti) throws IOException, JAXBException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(filename));

    document.open();

    Font headerFont = new Font(Font.FontFamily.ARIAL, 20, Font.BOLD);

    Paragraph header = new Paragraph("Frutti", headerFont);
    header.setSpacingAfter(30);
    document.add(header);

    Font paragraphFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    for(Frutta frutta : frutti) {
      Paragraph paragraph = new Paragraph(
          "Nome: " + frutta.getNome() +
          "Stagionalità: " + frutta.getStagionalita() +
          "Euro/Kg: " + frutta.getEurkg(),
          paragraphFont
        );
      document.add(paragraph);
    }

    document.add(new Paragraph("TODO: Footer", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC)));

    document.close();
  }
}
