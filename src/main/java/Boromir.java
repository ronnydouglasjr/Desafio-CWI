public class Boromir extends Guerreiro implements Humano {
  public Boromir() {
    super("Boromir", 7, 6, 3, 40, true);
  }

  @Override
  public String falar() {
    return "One does not simply walk into Mordor.";
  }

  @Override
  public void envelhecer() {
    setConstituicao(getConstituicao() - 2);
  }

  public String toString() {
    return "B";
  }
}
