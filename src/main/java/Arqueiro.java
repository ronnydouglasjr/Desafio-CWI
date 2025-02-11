public class Arqueiro extends Personagem {
  public Arqueiro(
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
    int posicaoAtual = -1;

    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] == this) {
        posicaoAtual = i;
        break;
      }
    }

    if (posicaoAtual == -1) return;

    if (this.isSociedade()) {

      for (int distancia = 1; distancia <= 3; distancia++) {
        int posicaoAlvo = posicaoAtual + distancia;
        if (posicaoAlvo < personagens.length) {
          Personagem defensor = personagens[posicaoAlvo];
          if (defensor != null
              && defensor.isSociedade() != this.isSociedade()
              && defensor.getConstituicao() > 0) {
            int dano = distancia * getAgilidade();
            defensor.setConstituicao(defensor.getConstituicao() - dano);
            break;
          }
        }
      }
    } else {
      for (int distancia = 3; distancia >= 1; distancia--) {
        int posicaoAlvo = posicaoAtual - distancia;
        if (posicaoAlvo >= 0) {
          Personagem defensor = personagens[posicaoAlvo];
          if (defensor != null
              && defensor.isSociedade() != this.isSociedade()
              && defensor.getConstituicao() > 0) {
            int dano = distancia * getAgilidade();
            defensor.setConstituicao(defensor.getConstituicao() - dano);
            break;
          }
        }
      }
    }
  }

  @Override
  public void mover(Personagem[] personagens) {
    int posicaoAtual = -1;
    boolean inimigoExite = true;

    for (int i = 0; i < personagens.length; i++) {
      if (personagens[i] == this) {
        posicaoAtual = i;
        break;
      }
    }

    if (posicaoAtual == -1) return;

    if (this.isSociedade()) {
      if (posicaoAtual + 1 < personagens.length && personagens[posicaoAtual + 1] == null) {
        personagens[posicaoAtual] = null;
        personagens[posicaoAtual + 1] = this;
      }
    } else {
      if (posicaoAtual - 1 >= 0 && personagens[posicaoAtual - 1] == null) {
        personagens[posicaoAtual] = null;
        personagens[posicaoAtual - 1] = this;
      }
    }
  }
}
