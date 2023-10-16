import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    if(args.length != 2){
      System.out.println("USAGE: java Main inputFile outputFile");
    }

    String fileName = args[0];
    String outFileName = args[1];
    String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
    String outFleExtension = outFileName.substring(outFileName.lastIndexOf('.') + 1);

    //try catch statement to catch possible exception in file opening
    try {
      IFruttoFile fruttaFile;

      if(fileExtension.equals("json")) {
        fruttaFile = new FruttaJson();
      } else {
        fruttaFile = new FruttaCSV();
      }

      ArrayList<Frutta> frutti = fruttaFile.readFile(fileName);

      for(Frutta f : frutti){
        f.setEurkg((int)(f.getEurkg() * 1.1));
        System.out.println(f);
      }
      fruttaFile.writeFile(outFileName, frutti);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
