import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Frutti")
public class Frutti {
  private ArrayList<Frutta> frutti = new ArrayList<Frutta>();

  public Frutti() {}
  public Frutti(ArrayList<Frutta> frutti) {
    this.frutti = frutti;
  }

  @XmlElement(name = "Frutta")
  public void setFrutti(ArrayList<Frutta> frutti) {
    this.frutti = frutti;
  }

  public ArrayList<Frutta> getFrutti() {
    return frutti;
  }
}

