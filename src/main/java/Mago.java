public class Mago extends Personagem {
    public Mago(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
        super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
    }

    @Override
    public void atacar(Personagem[] personagens) {
        int dano = getInteligencia();
        for (Personagem personagem : personagens) {
            if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem != this && personagem.getConstituicao() > 0) {
                personagem.setConstituicao(personagem.getConstituicao() - dano);
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

        if (!outrosPersonagens) {
            int novaPosicao = this.getPosicao() + 1;
            if (novaPosicao < 10) {
                this.setPosicao(novaPosicao);
                System.out.println(this.getNome() + " moveu para a posição " + novaPosicao);
            }
        }
    }
}