package classes;

import interfaces.Humano;
import interfaces.Monstro;
import racas.Guerreiro;

public class Urukhai extends Guerreiro implements Monstro, Humano {
  public Urukhai() {
    super("Urukhai", 8, 6, 3, 45, false);
  }

  @Override
  public String falar() {
    return "Looks like meat's back on the menu boys!";
  }

  @Override
  public void envelhecer() {
    setConstituicao(getConstituicao() - 2);
  }

  @Override
  public String grunhido() {
    return "Uuurrrrrr";
  }

  public String toString() {
    return "U";
  }
}
