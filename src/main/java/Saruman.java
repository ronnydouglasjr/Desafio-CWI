public class Saruman extends Mago implements Maia {
  public Saruman() {
    super("Saruman", 2, 2, 9, 70, false);
  }

  @Override
  public String fala() {
    return "Against the power of Mordor there can be no victory.";
  }

  @Override
  public void ressucitar() {
    if (this.getConstituicao() == 0) {
      this.setConstituicao(this.getConstituicao());
    }
  }

  public String toString() {
    return "S";
  }
}
