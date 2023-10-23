import java.io.IOException;
import java.util.ArrayList;
import jakarta.xml.bind.JAXBException;

public class Main{
  public static void main(String[] args){
    if(args.length != 2){
      System.out.println("USAGE: java Main inputFile outputFile\n");
    }

    String fileName = args[0];
    String outFileName = args[1];

    String inFileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
    String outFileExtension = outFileName.substring(outFileName.lastIndexOf('.') + 1);

    //try catch statement to catch possible exception in file opening
    try {
      IFruttoFile inFruttaFile;
      IFruttoFile outFruttaFile;

      switch (inFileExtension) {
        case "json":
          inFruttaFile = new FruttaJson();
          break;
        case "xml":
          inFruttaFile = new FruttaXML();
          break;
        case "csv":
          inFruttaFile = new FruttaCSV();
          break;
        case "xls":
          inFruttaFile = new FruttaXLS();
          break;
        case "xlsx":
          throw new IOException("Unsupported XLSX");
          // break;
        default:
          throw new IOException("File extension not supported");
          // break;
      }

      switch (outFileExtension) {
        case "json":
          outFruttaFile = new FruttaJson();
          break;
        case "xml":
          outFruttaFile = new FruttaXML();
          break;
        case "csv":
          outFruttaFile = new FruttaCSV();
          break;
        case "xls":
          outFruttaFile = new FruttaXLS();
          break;
        case "xlsx":
          throw new IOException("Unsupported XLSX");
          // break;
        default:
          throw new IOException("File extension not supported");
          // break;
      }


      ArrayList<Frutta> frutti = inFruttaFile.readFile(fileName);

       // for(Frutta f : frutti){
       //   f.setEurkg((int)(f.getEurkg() * 1.1));
       //   System.out.println(f);
       // }

      outFruttaFile.writeFile(outFileName, frutti);

      IFruttoFile xls = new FruttaXLS();
      xls.writeFile("frutta.xls", frutti);

    } catch (IOException | JAXBException e) {
      e.printStackTrace();
    }
  }
}
