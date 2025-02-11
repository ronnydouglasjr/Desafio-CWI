public class Gandalf extends Mago implements Maia {
  public Gandalf() {
    super("Gandalf", 2, 3, 10, 80, true);
  }

  @Override
  public String fala() {
    return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
  }

  @Override
  public void ressucitar() {
    if (this.getConstituicao() == 0) {
      this.setConstituicao(80);
    }
  }

  public String toString() {
    return "G";
  }
}
