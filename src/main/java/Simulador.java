import java.util.ArrayList;
import java.util.List;

public class Simulador {
    private Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public static int[] obterProximaJogada(String[] tabuleiro, Integer atual, Integer anterior, int ladoEsquerdoInicial, int ladoDireitoInicial) {
        List<Integer> ladoEsquerdo = new ArrayList<>();
        for (int i = ladoEsquerdoInicial; i >= 0; i--) {
            ladoEsquerdo.add(i);
        }

        List<Integer> ladoDireito = new ArrayList<>();
        for (int i = ladoDireitoInicial; i < 10; i++) {
            ladoDireito.add(i);
        }

        if (atual == null) {
            for (int i : ladoEsquerdo) {
                if (!tabuleiro[i].isEmpty()) {
                    return new int[]{i, -1}; // -1 indica que não há anterior
                }
            }
        } else if (anterior == null) {
            for (int i : ladoDireito) {
                if (!tabuleiro[i].isEmpty()) {
                    return new int[]{i, atual};
                }
            }
        } else if (atual > ladoEsquerdoInicial) {
            for (int i : ladoEsquerdo) {
                if (!tabuleiro[i].isEmpty() && i < anterior) {
                    return new int[]{i, atual};
                }
            }
            for (int i : ladoEsquerdo) {
                if (!tabuleiro[i].isEmpty()) {
                    return new int[]{i, atual};
                }
            }
        } else if (atual < ladoDireitoInicial) {
            for (int i : ladoDireito) {
                if (!tabuleiro[i].isEmpty() && i > anterior) {
                    return new int[]{i, atual};
                }
            }
            for (int i : ladoDireito) {
                if (!tabuleiro[i].isEmpty()) {
                    return new int[]{i, atual};
                }
            }
        }

        return new int[]{-1, -1}; // Caso não encontre uma jogada válida
    }


    public void simular() throws SauronDominaOMundoException {
        boolean verificador = true;
        int posicaoAtual = -1;

        while (verificador) {
            Personagem personagemAnterior = null;
            for (int i = 0; i < 10; i++) {
                Personagem personagem = mapa.buscarCasa(i);
                if (personagem != null && personagem.getConstituicao() > 0 && personagem != personagemAnterior ) {
                    System.out.println("-----------Rodada-----------");
                    System.out.println("Mapa: " + mapa.exibir());
                    System.out.println("Vida: " + mapa.exibirVida());

                    // Ataca
                    personagem.atacar(mapa.getPersonagens());

                    // Move
                    personagem.mover(mapa.getPersonagens());

                    personagemAnterior = personagem;

                    for (int t = 0; t < 10; t++) {
                        Personagem p = mapa.buscarCasa(t);
                        if (p != null && p.getConstituicao() <= 0) {
                            mapa.remover(t);
                        }
                    }

                    boolean inimigoExiste = false;
                    for (int t = 0; t < 10; t++) {
                        Personagem p = mapa.buscarCasa(t);
                        if (p != null && !p.isSociedade()) {
                            inimigoExiste = true;
                            break;
                        }
                    }

                    boolean sociedadeExiste = false;
                    for (int t = 0; t < 10; t++) {
                        Personagem p = mapa.buscarCasa(t);
                        if (p != null && p.isSociedade()) {
                            sociedadeExiste = true;
                            break;
                        }
                    }

                    if (!inimigoExiste) {
                        for (int t = 0; t < 10; t++) {
                            personagem.mover(mapa.getPersonagens());
                        }
                        verificador = false;
                        System.out.println("Mapa: " + mapa.exibir());
                        System.out.println("A Sociedade do Anel venceu!");
                        break;
                    }

                    if (!sociedadeExiste) {
                        verificador = false;
                        System.out.println("Mapa: " + mapa.exibir());
                        throw new SauronDominaOMundoException("A humanidade sofre perante a tirania de Sauron.");
                    }
                }
            }
        }
    }
}