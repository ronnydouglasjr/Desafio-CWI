public class Mapa {
    private Personagem[] casas;

    public Mapa() {
        casas = new Personagem[10];
    }

    public Personagem[] getPersonagens() {
        return casas;
    }

    public String exibir() {
        StringBuilder sb = new StringBuilder("|");
        for (Personagem personagem : casas) {
            if (personagem == null || personagem.getConstituicao() <= 0) {
                sb.append(" |");
            } else {
                sb.append(personagem.getNome().charAt(0)).append("|");
            }
        }
        return sb.toString();
    }

    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (casas[posicao] != null && casas[posicao].getConstituicao() > 0) {
            throw new PosicaoOcupadaException("Posição " + posicao + " já está ocupada.");
        }

        for (int i = 0; i < casas.length; i++) {
            if (casas[i] != null && casas[i].equals(personagem) && casas[i].getConstituicao() > 0) {
                throw new PersonagemJaEstaNoMapaException("Personagem " + personagem.toString() + " já está no mapa.");
            }
        }
        casas[posicao] = personagem;
    }

    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        for (int i = 0; i < casas.length; i++) {
            if (casas[i] != null && casas[i].equals(personagem) && casas[i].getConstituicao() > 0) {
                return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException("Personagem " + personagem.getNome() + " não encontrado no mapa.");
    }

    public Personagem buscarCasa(int posicao) {
        if (posicao < 0 || posicao >= casas.length) {
            return null;
        }
        Personagem personagem = casas[posicao];
        if (personagem != null && personagem.getConstituicao() > 0) {
            return personagem;
        }
        return null;
    }
}