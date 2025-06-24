package classes;

import interfaces.Maia;
import racas.Mago;

public class Gandalf extends Mago implements Maia {
  public Gandalf() {
    super("Gandalf", 2, 3, 10, 80, true);
  }

  @Override
  public String falar() {
    return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
  }

  @Override
  public Gandalf ressuscitar() {
    if (this.getConstituicao() == 0) {
      return new Gandalf();
    }
    return this;
  }

  public String toString() {
    return "G";
  }
}
