public class Mapa {
  private Personagem[] casas;

  public Mapa() {
    casas = new Personagem[10];
  }

  public Personagem[] getPersonagens() {
    return casas;
  }

  public void remover(int i) {
    casas[i] = null;
  }

  public String exibir() {
    StringBuilder sb = new StringBuilder("|");
    for (Personagem personagem : casas) {
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
    for (Personagem personagem : casas) {
      if (personagem == null) {
        sb.append(" |");
      } else {
        sb.append(personagem.getConstituicao()).append("|");
      }
    }
    return sb.toString();
  }

  public void inserir(int posicao, Personagem personagem)
      throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
    if (casas[posicao] != null && casas[posicao].getConstituicao() > 0) {
      throw new PosicaoOcupadaException("Posição " + posicao + " já está ocupada.");
    }

    for (int i = 0; i < casas.length; i++) {
      if (casas[i] != null && casas[i].equals(personagem) && casas[i].getConstituicao() > 0) {
        throw new PersonagemJaEstaNoMapaException("Personagem " + personagem + " já está no mapa.");
      }
    }
    casas[posicao] = personagem;
  }

  public Personagem buscarCasa(int posicao) {
    if (posicao < 0 || posicao >= casas.length) {
      return null;
    }
    Personagem personagem = casas[posicao];
    if (personagem != null) {
      return personagem;
    }
    return null;
  }
}
