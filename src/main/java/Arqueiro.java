public class Arqueiro extends Personagem {
    public Arqueiro(String nome, int forca, int agilidade, int inteligencia, int constituicao, boolean sociedade) {
        super(nome, forca, agilidade, inteligencia, constituicao, sociedade);
    }

    @Override
    public void atacar(Personagem[] personagens) {
        for (int distancia = 3; distancia >= 1; distancia--) {
            for (Personagem personagem : personagens) {
                if (personagem != null && personagem.isSociedade() != this.isSociedade() && personagem.getConstituicao() > 0 && Math.abs(personagem.getPosicao() - this.getPosicao()) == distancia) {
                    int dano = distancia * getAgilidade();
                    personagem.setConstituicao(personagem.getConstituicao() - dano);
                    System.out.println(this.getNome() + " atacou " + personagem.getNome() + " causando " + dano + " de dano!");
                    return;
                }
            }
        }
    }

    @Override
    public void mover(Personagem[] personagens) {
        int novaPosicao1 = this.getPosicao() + (this.isSociedade() ? 1 : -1);
        int novaPosicao2 = this.getPosicao() + (this.isSociedade() ? 2 : -2);
        boolean segundaPosicaoLivre = true;
        for (Personagem personagem : personagens) {
            if (personagem != null && personagem.getPosicao() == novaPosicao2 && personagem.getConstituicao() > 0) {
                segundaPosicaoLivre = false;
                break;
            }
        }

        if (segundaPosicaoLivre && novaPosicao2 >= 0 && novaPosicao2 < 10) {
            this.setPosicao(novaPosicao2);
            System.out.println(this.getNome() + " moveu para a posição " + novaPosicao2);
        } else if (novaPosicao1 >= 0 && novaPosicao1 < 10) {
            this.setPosicao(novaPosicao1);
            System.out.println(this.getNome() + " moveu para a posição " + novaPosicao1);
        }
    }
}