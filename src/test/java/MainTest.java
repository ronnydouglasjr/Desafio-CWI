import classes.*;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

  @Test
  public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraUrukhaiOrcEGoblim()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    // Início:  "|A| |I | | | | |U|O|M|"
    String resultadoEsperado = "| | | | | | | | | |A|";

    Aragorn aragorn = new Aragorn();
    Gimli gimli = new Gimli();
    Urukhai urukhai = new Urukhai();
    Orc orc = new Orc();
    Goblim goblim = new Goblim();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, aragorn);
    mapa.inserirPersonagem(2, gimli);
    mapa.inserirPersonagem(7, urukhai);
    mapa.inserirPersonagem(8, orc);
    mapa.inserirPersonagem(9, goblim);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibirTabuleiro());
  }

  @Test
  public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início:  "|A|L| | | | | |O| |M|"
    String resultadoEsperado = "| | | |A| | | | | |L|";

    Aragorn aragorn = new Aragorn();
    Legolas legolas = new Legolas();
    Orc orc = new Orc();
    Goblim goblim = new Goblim();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, aragorn);
    mapa.inserirPersonagem(1, legolas);
    mapa.inserirPersonagem(7, orc);
    mapa.inserirPersonagem(9, goblim);
    simulador.simular();

    System.out.println(mapa.exibirTabuleiro());

    Assert.assertEquals(resultadoEsperado, mapa.exibirTabuleiro());
  }

  @Test(expected = SauronDominaOMundoException.class)
  public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    // Início: "| | |I| | | | |U|O|M|"
    // Fim:    "| | | | | | |O|M| | |"

    Gimli gimli = new Gimli();
    Urukhai urukhai = new Urukhai();
    Orc orc = new Orc();
    Goblim goblim = new Goblim();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(2, gimli);
    mapa.inserirPersonagem(7, urukhai);
    mapa.inserirPersonagem(8, orc);
    mapa.inserirPersonagem(9, goblim);
    simulador.simular();
  }

  @Test
  public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    // Início:  "|G| | | | | | | | |S|"
    String resultadoEsperado = "| | | | | | | | | |G|";

    Gandalf gandalf = new Gandalf();
    Saruman saruman = new Saruman();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, gandalf);
    mapa.inserirPersonagem(9, saruman);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibirTabuleiro());
  }

  @Test
  public void deveVencerSociedadeQuandoLegonasBatalharContraUrukhaiEOrc()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    // Início:  "|L| | | | | | | |U|O|"
    String resultadoEsperado = "| | | | | | | | | |L|";

    Legolas legolas = new Legolas();
    Orc orc = new Orc();
    Urukhai urukhai = new Urukhai();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, legolas);
    mapa.inserirPersonagem(8, urukhai);
    mapa.inserirPersonagem(9, orc);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibirTabuleiro());
  }

  @Test(expected = SauronDominaOMundoException.class)
  public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    // Início:  "|L| | | | | | |U|O|S|"
    // Fim:     "| | | | | | | | | |S|";

    Legolas legolas = new Legolas();
    Orc orc = new Orc();
    Urukhai urukhai = new Urukhai();
    Saruman saruman = new Saruman();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, legolas);
    mapa.inserirPersonagem(7, orc);
    mapa.inserirPersonagem(8, urukhai);
    mapa.inserirPersonagem(9, saruman);

    simulador.simular();
  }

  @Test(expected = SauronDominaOMundoException.class)
  public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início:  "|B| | | | | | | | |U|"
    // Fim:     "| | | | |U| | | | | |";

    Boromir boromir = new Boromir();
    Urukhai urukhai = new Urukhai();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, boromir);
    mapa.inserirPersonagem(9, urukhai);
    simulador.simular();
  }

  @Test
  public void deveVencerSociedadeNaBatalhaMagoContraMago()
      // Início:  "|G| | | | | | | | |S|"
      // Fim:     "| | | | | | | | | |G|";
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    Gandalf gandalf = new Gandalf();
    Saruman saruman = new Saruman();

    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, gandalf);
    mapa.inserirPersonagem(9, saruman);
    simulador.simular();

    System.out.println(mapa.exibirTabuleiro());
  }

  @Test
  public void deveVencerSociedadeNaBatalhaArqueiroContraArqueiro()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    Legolas legolas = new Legolas();
    Goblim goblim = new Goblim();

    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserirPersonagem(0, legolas);
    mapa.inserirPersonagem(9, goblim);
    simulador.simular();

    System.out.println(mapa.exibirTabuleiro());
  }
}
