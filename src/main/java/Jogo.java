import java.util.ArrayList;
import java.util.List;

public class Jogo {
    public static void main(String[] args) {
        List<Object[]> testes = new ArrayList<>();
        testes.add(new Object[]{new String[]{"A", "", "B", "X", "", "", "", "", "D", "E"}, 4, 5, "XDBEADXEBDAE"});
        testes.add(new Object[]{new String[]{"A", "", "B", "", "", "", "", "C", "D", "E"}, 4, 5, "BCADBEACBDAE"});
        testes.add(new Object[]{new String[]{"A", "", "B", "", "", "", "", "", "D", "E"}, 4, 5, "BDAEBDAEBDAE"});
        testes.add(new Object[]{new String[]{"A", "C", "", "", "", "", "B", "X", "D", "E"}, 4, 5, "CBAXCDAECBAX"});
        testes.add(new Object[]{new String[]{"A", "C", "B", "X", "", "", "", "", "D", "E"}, 4, 5, "XDBECDAEXDBE"});
        testes.add(new Object[]{new String[]{"A", "", "B", "X", "", "", "", "", "D", "E"}, 2, 3, "BXADBEAXBDAE"});
        testes.add(new Object[]{new String[]{"A", "", "B", "", "", "", "", "C", "D", "E"}, 1, 2, "ABACADAEABAC"});
        testes.add(new Object[]{new String[]{"A", "C", "", "", "", "", "B", "X", "D", "E"}, 7, 8, "XDBECDAEXDBE"});

        for (Object[] teste : testes) {
            String[] tabuleiro = (String[]) teste[0];
            int ladoEsquerdoInicial = (int) teste[1];
            int ladoDireitoInicial = (int) teste[2];
            String resultadoEsperado = (String) teste[3];

            Integer anterior = null;
            Integer atual = null;
            StringBuilder resultado = new StringBuilder();

            for (int i = 0; i < 12; i++) {
                int[] proximaJogada = Simulador.obterProximaJogada(tabuleiro, atual, anterior, ladoEsquerdoInicial, ladoDireitoInicial);
                atual = proximaJogada[0];
                anterior = proximaJogada[1];
                resultado.append(tabuleiro[atual]);
            }

            System.out.println("---------------------------------");
            if (!resultado.toString().equals(resultadoEsperado)) {
                System.out.println("Teste falhou!\nEsperado: " + resultadoEsperado + "\nObtido: " + resultado);
            } else {
                System.out.println("Teste passou! Saída: " + resultado);
            }
        }
    }
}