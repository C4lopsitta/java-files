import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
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

      if(inFileExtension.equals("json")) {
        inFruttaFile = new FruttaJson();
      } else if(inFileExtension.equals("xml")) {
        inFruttaFile = new FruttaXML();
      } else if(inFileExtension.equals("csv")) {
        inFruttaFile = new FruttaCSV();
      } else {
        throw new IOException("File extension not supported");
      }
 
      if(outFileExtension.equals("json")) {
        outFruttaFile = new FruttaJson();
      } else if(outFileExtension.equals("xml")) {
        outFruttaFile = new FruttaXML();
      } else if(outFileExtension.equals("csv")) {
        outFruttaFile = new FruttaCSV();
      } else {
        throw new IOException("File extension not supported");
      }

      ArrayList<Frutta> frutti = inFruttaFile.readFile(fileName);

      // for(Frutta f : frutti){
      //   f.setEurkg((int)(f.getEurkg() * 1.1));
      //   System.out.println(f);
      // }

      outFruttaFile.writeFile(outFileName, frutti);

    } catch (IOException | JAXBException e) {
      e.printStackTrace();
    }
  }
}
