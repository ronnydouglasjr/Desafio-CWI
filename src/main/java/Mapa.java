import classes_abstrata.Personagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PosicaoOcupadaException;

public class Mapa {
  private Personagem[] tabuleiro;

  public Mapa() {
    tabuleiro = new Personagem[10];
  }

  public Personagem[] getPersonagens() {
    return tabuleiro;
  }

  public void removerPersonagem(int posicao) {
    tabuleiro[posicao] = null;
  }

  public String exibirTabuleiro() {
    StringBuilder sb = new StringBuilder("|");
    for (Personagem personagem : tabuleiro) {
      if (personagem == null) {
        sb.append(" |");
      } else if (personagem.getConstituicao() <= 0) {
        sb.append(" ");
        sb.append(personagem.toString().charAt(0));
        sb.append(" |");
      } else {
        sb.append(personagem.toString().charAt(0)).append("|");
      }
    }
    return sb.toString();
  }

  public String exibirVida() {
    StringBuilder sb = new StringBuilder("|");
    for (Personagem personagem : tabuleiro) {
      if (personagem == null) {
        sb.append(" |");
      } else {
        sb.append(personagem.getConstituicao()).append("|");
      }
    }
    return sb.toString();
  }

  public void inserirPersonagem(int posicao, Personagem personagem)
      throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
    if (tabuleiro[posicao] != null && tabuleiro[posicao].getConstituicao() > 0) {
      throw new PosicaoOcupadaException("Posição " + posicao + " já está ocupada.");
    }

    for (Personagem personagens : tabuleiro) {
      if (personagens != null
          && personagens.equals(personagem)
          && personagens.getConstituicao() > 0) {
        throw new PersonagemJaEstaNoMapaException("Personagem " + personagem + " já está no mapa.");
      }
    }
    tabuleiro[posicao] = personagem;
  }

  public Personagem buscarPersonagem(int posicao) {
    if (posicao < 0 || posicao >= tabuleiro.length) {
      return null;
    }
    Personagem personagem = tabuleiro[posicao];
    if (personagem != null) {
      return personagem;
    }
    return null;
  }
}
