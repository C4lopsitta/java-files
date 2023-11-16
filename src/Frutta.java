import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

//root element for xml
@XmlRootElement(name = "Frutta")
public class Frutta{
  private String nome = null;
  private Stagione stagionalita = null;
  private int eurkg = 0;
  private int id = -1;

  public Frutta(){}
  public Frutta(String nome, Stagione stagionalita, int eurkg){
    this.nome = nome;
    this.stagionalita = stagionalita;
    this.eurkg = eurkg;
  }
  public Frutta(String line){
    String[] attributes = line.split("[;,]");
    this.nome = attributes[0];
    this.stagionalita = Stagione.valueOf(attributes[1]);
    this.eurkg = Integer.parseInt(attributes[2]);
  }
  public Frutta(int id, String nome, Stagione stagione, int eurkg) {
    this(nome, stagione, eurkg);
    this.id = id;
  }

  //setters
  @XmlElement()
  public void setNome(String nome){
    this.nome = nome;
  }

  @XmlAttribute()
  public void setStagionalita(Stagione stagionalita){
    this.stagionalita = stagionalita;
  }

  @XmlAttribute()
  public void setEurkg(int eurkg){
    this.eurkg = eurkg;
  }

  public void setId(int id) { this.id = id; }

  //getters
  public String getNome(){
    return this.nome;
  }
  public Stagione getStagionalita(){
    return this.stagionalita;
  }
  public int getEurkg(){
    return this.eurkg;
  }
  public int getId() { return this.id; }

  public String toString(){
    return "[FRUTTO ID " + this.id + "]: " +
      "\n\tnome: " + this.nome +
      "\n\tstagionalita: " + this.stagionalita +
      "\n\teur/kg: " + this.eurkg;
  }

  public String toCSV(){
    return nome + ";" + stagionalita + ";" + eurkg;
  }

  public String[] toRow() {
    String[] row = new String[3];
    row[0] = this.nome;
    row[1] = this.stagionalita.toString();
    row[2] = Integer.toString(eurkg);
    return row;
  }
}
