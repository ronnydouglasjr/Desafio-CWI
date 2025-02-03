public class Arqueiro extends Personagem {
    public Arqueiro(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
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

            for (int distancia = 3; distancia >= 1; distancia--) {
                int posicaoAlvo = posicaoAtual + distancia;
                if (posicaoAlvo < personagens.length) {
                    Personagem personagem = personagens[posicaoAlvo];
                    if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0) {
                        int dano = distancia * getAgilidade();
                        personagem.setConstituicao(getConstituicao() - dano);
                        break;
                    }
                }
            }
        } else {
            for (int distancia = 3; distancia >= 1; distancia--) {
                int posicaoAlvo = posicaoAtual - distancia;
                if (posicaoAlvo >= 0) {
                    Personagem personagem = personagens[posicaoAlvo];
                    if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0) {
                        int dano = distancia * getAgilidade();
                        personagem.setConstituicao(getConstituicao() - dano);
                        break;
                    }
                }
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

        if (posicaoAtual == -1) return;

        if (this.isSociedade()) {
            if (posicaoAtual + 2 < personagens.length && personagens[posicaoAtual + 2] == null) {
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual + 2] = this;
            } else if (posicaoAtual + 1 < personagens.length && personagens[posicaoAtual + 1] == null) {
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual + 1] = this;
            }
        } else {

            if (posicaoAtual - 2 >= 0 && personagens[posicaoAtual - 2] == null) {
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual - 2] = this;
            } else if (posicaoAtual - 1 >= 0 && personagens[posicaoAtual - 1] == null) {
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual - 1] = this;
            }
        }
    }
}
