package classes;

import interfaces.Maia;
import racas.Mago;

public class Saruman extends Mago implements Maia {
  public Saruman() {
    super("Saruman", 2, 2, 9, 70, false);
  }

  @Override
  public String falar() {
    return "Against the power of Mordor there can be no victory.";
  }

  @Override
  public Object ressucitar() {
      return null;
  }

  public String toString() {
    return "S";
  }
}
