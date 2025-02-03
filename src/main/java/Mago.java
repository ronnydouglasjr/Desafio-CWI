public class Mago extends Personagem {
    public Mago(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
        super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
    }

    @Override
    public void atacar(Personagem[] personagens) {
        int dano = getInteligencia();
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

        if (this.isSociedade()){
            for (int i = posicaoAtual + 1; i < personagens.length; i++) {
                Personagem personagem = personagens[i];
                if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem != this && personagem.getConstituicao() > 0) {
                    personagem.setConstituicao(personagem.getConstituicao() - dano);
                }
            }
        } else {
            for (int i = posicaoAtual - 1; i >= 0; i--) {
                Personagem personagem = personagens[i];
                if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0) {
                    personagem.setConstituicao(personagem.getConstituicao() - dano);
                }
            }
        }
    }

    @Override
    public void mover(Personagem[] personagens) {

        boolean outrosPersonagens = false;
        for (Personagem personagem : personagens) {
            if (personagem != null && personagem != this && personagem.getConstituicao() > 0) {
                outrosPersonagens = true;
                break;
            }
        }

        if (outrosPersonagens) {
            return;
        }

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