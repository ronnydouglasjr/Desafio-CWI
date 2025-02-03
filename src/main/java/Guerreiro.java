public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
        super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
    }

    @Override
    public void atacar(Personagem[] personagens) {
        int dano = getForca() * 2;
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

        if (posicaoAtual > 0) {
            Personagem personagem = personagens[posicaoAtual - 1];
            if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0) {
                setConstituicao(getConstituicao() - dano);
            }
        }

        if (posicaoAtual < personagens.length - 1) {
            Personagem personagem = personagens[posicaoAtual + 1];
            if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0) {
                setConstituicao(getConstituicao() - dano);
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
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual + 1] = this;
            }
        } else {
            if (posicaoAtual > 0 && personagens[posicaoAtual - 1] == null) {
                personagens[posicaoAtual] = null;
                personagens[posicaoAtual - 1] = this;
            }
        }
    }
}
