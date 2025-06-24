package racas;

import classes_abstrata.Personagem;

public class Guerreiro extends Personagem {
  public Guerreiro(
      String nome,
      int forca,
      int agilidade,
      int inteligencia,
      int constituicao,
      boolean sociedade) {
    super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
  }

  @Override
  public void atacar(Personagem[] personagens) {
    int dano = getForca() * 2;
    System.out.println(dano);
    int posicaoAtual = -1;

    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] == this) {
        posicaoAtual = i;
        break;
      }
    }
    System.out.println(posicaoAtual);

    int posicaoAtaque;
    if (posicaoAtual > 0 && posicaoAtual < personagens.length - 1) {
      posicaoAtaque = this.isSociedade() ? (posicaoAtual + 1) : (posicaoAtual - 1);
    } else {
      return;
    }

    if (posicaoAtaque > 0 && posicaoAtaque < personagens.length - 1) {
      Personagem defensor = personagens[posicaoAtaque];
      if (defensor != null
          && defensor.isSociedade() != this.isSociedade()
          && defensor.getConstituicao() > 0) {
        defensor.setConstituicao(defensor.getConstituicao() - dano);
      }
    }
  }

  @Override
  public void mover(Personagem[] personagens) {
    int posicaoAtual = -1;

    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] == this) {
        posicaoAtual = i;
        break;
      }
    }

    if (posicaoAtual == -1) {
      return;
    }

    if (this.isSociedade()) {

      if (posicaoAtual < personagens.length - 1 && personagens[posicaoAtual + 1] == null) {
        personagens[posicaoAtual + 1] = this;
        personagens[posicaoAtual] = null;
      }
    } else {
      if (posicaoAtual > 0 && personagens[posicaoAtual - 1] == null) {
        personagens[posicaoAtual - 1] = this;
        personagens[posicaoAtual] = null;
      }
    }
  }
}
