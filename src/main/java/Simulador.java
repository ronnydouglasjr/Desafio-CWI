public class Simulador {
    private Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() throws SauronDominaOMundoException {
        while (true) {
            for (int i = 0; i < 10; i++) {
                Personagem personagem = mapa.buscarCasa(i);
                if (personagem != null && personagem.isSociedade() && i == 9) {
                    System.out.println("A Sociedade do Anel venceu!");
                    return;
                }
            }

            boolean sociedadeExiste = false;
            for (int i = 0; i < 10; i++) {
                Personagem personagem = mapa.buscarCasa(i);
                if (personagem != null && personagem.isSociedade()) {
                    sociedadeExiste = true;
                    break;
                }
            }
            if (!sociedadeExiste) {
                throw new SauronDominaOMundoException("A humanidade sofre perante a tirania de Sauron.");
            }

            for (int i = 0; i < 10; i++) {
                Personagem personagem = mapa.buscarCasa(i);
                if (personagem != null && personagem.getConstituicao() > 0) {
                    // Ataca
                    personagem.atacar(mapa.getPersonagens());

                    // Move
                    personagem.mover(mapa.getPersonagens());
                }
            }

            System.out.println("Mapa: " + mapa.exibir());
        }
    }
}