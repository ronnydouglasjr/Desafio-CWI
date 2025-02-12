public abstract class Personagem {
  private String nome;
  private int forca;
  private int agilidade;
  private int inteligencia;
  private int constituicao;
  private boolean sociedade;

  public Personagem(
      String nome,
      int forca,
      int agilidade,
      int inteligencia,
      int constituicao,
      boolean sociedade) {
    this.nome = nome;
    this.forca = forca;
    this.agilidade = agilidade;
    this.inteligencia = inteligencia;
    this.constituicao = constituicao;
    this.sociedade = sociedade;
  }

  public int getAgilidade() {
    return agilidade;
  }

  public int getInteligencia() {
    return inteligencia;
  }

  public int getConstituicao() {
    return constituicao;
  }

  public void setConstituicao(int constituicao) {
    this.constituicao = constituicao;
  }

  public int getForca() {
    return forca;
  }

  public boolean isSociedade() {
    return sociedade;
  }

  public abstract void atacar(Personagem[] personagems);

  public abstract void mover(Personagem[] personagems);
}
