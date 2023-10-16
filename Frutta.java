public class Frutta{
  private String nome = null;
  private Stagione stagionalita = null;
  private int eurkg = 0;

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

  //setters
  public void setNome(String nome){
    this.nome = nome;
  }
  public void setStagionalita(Stagione stagionalita){
    this.stagionalita = stagionalita;
  }
  public void setEurkg(int eurkg){
    this.eurkg = eurkg;
  }

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

  public String toString(){
    return "[FRUTTO]: " +
      "\n\tnome: " + this.nome +
      "\n\tstagionalita: " + this.stagionalita +
      "\n\teur/kg: " + this.eurkg;
  }

  public String toCSV(){
    return nome + ";" + stagionalita + ";" + eurkg;
  }

}
