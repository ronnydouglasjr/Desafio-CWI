import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        // Início:  "|A|L| | | | | |O| |M|"
        String resultadoEsperado = "| | | | |A| | | | |L|";

        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserir(0, aragorn);
        mapa.inserir(1, legolas);
        mapa.inserir(7, orc);
        mapa.inserir(9, goblim);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
}
