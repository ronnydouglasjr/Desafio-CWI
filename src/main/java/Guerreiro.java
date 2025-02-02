public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
        super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
    }

    @Override
    public void atacar(Personagem[] personagens) {
        int dano = getForca() * 2;
        for (Personagem personagem : personagens) {
            if (personagem.isSociedade() != this.isSociedade() && personagem != this && Math.abs(personagem.getPosicao() - this.getPosicao()) == 1) {
                personagem.setConstituicao(dano);
            }
        }
    }

    @Override
    public void mover(Personagem[] personagens) {
        int novaPosicao = this.getPosicao() + (this.isSociedade() ? 1 : -1);
        if (novaPosicao >= 0 && novaPosicao < 10) {
            boolean posicaoLivre = true;
            for (Personagem personagem : personagens) {
                if (personagem != null && personagem.getPosicao() == novaPosicao && personagem.getConstituicao() > 0) {
                    posicaoLivre = false;
                    break;
                }
            }
            if (posicaoLivre) {
                this.setPosicao(novaPosicao);
                System.out.println(this.getNome() + " moveu para a posição " + novaPosicao);
            }
        }
    }
}
