import org.junit.Assert;
import org.junit.Test;

public class MainTest {

  @Test
  public void teste1()
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

    mapa.inserir(0, aragorn);
    mapa.inserir(2, gimli);
    mapa.inserir(7, urukhai);
    mapa.inserir(8, orc);
    mapa.inserir(9, goblim);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibir());
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

    mapa.inserir(0, aragorn);
    mapa.inserir(1, legolas);
    mapa.inserir(7, orc);
    mapa.inserir(9, goblim);
    simulador.simular();

    System.out.println(mapa.exibir());

    Assert.assertEquals(resultadoEsperado, mapa.exibir());
  }

  @Test(expected = SauronDominaOMundoException.class)
  public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início: "|A| |I| | | | |U|O|M|"
    // Fim:    "| | | | | | |O|M| | |"

    Gimli gimli = new Gimli();
    Urukhai urukhai = new Urukhai();
    Orc orc = new Orc();
    Goblim goblim = new Goblim();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(2, gimli);
    mapa.inserir(7, urukhai);
    mapa.inserir(8, orc);
    mapa.inserir(9, goblim);
    simulador.simular();
  }

  @Test
  public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início:  "|G| | | | | | | | |S|"
    String resultadoEsperado = "| | | | | | | | | |G|";

    Gandalf gandalf = new Gandalf();
    Saruman saruman = new Saruman();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(0, gandalf);
    mapa.inserir(9, saruman);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibir());
  }

  @Test
  public void teste2()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início:  "|L| | | | | | | |U|O|"
    String resultadoEsperado = "| | | | | | | | | |L|";

    Legolas legolas = new Legolas();
    Orc orc = new Orc();
    Urukhai urukhai = new Urukhai();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(0, legolas);
    mapa.inserir(8, urukhai);
    mapa.inserir(9, orc);
    simulador.simular();

    Assert.assertEquals(resultadoEsperado, mapa.exibir());
  }

  @Test(expected = SauronDominaOMundoException.class)
  public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    // Início:  "|L| | | | | | | |U|O|"
    // Fim:     "| | | | | |U| | | | |";

    Legolas legolas = new Legolas();
    Orc orc = new Orc();
    Urukhai urukhai4 = new Urukhai();
    Urukhai urukhai = new Urukhai();
    Urukhai urukhai2 = new Urukhai();
    Urukhai urukhai3 = new Urukhai();
    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(0, legolas);
    mapa.inserir(5, urukhai2);
    mapa.inserir(6, urukhai4);
    mapa.inserir(7, urukhai3);
    mapa.inserir(8, urukhai);
    mapa.inserir(9, orc);
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

    mapa.inserir(0, boromir);
    mapa.inserir(9, urukhai);
    simulador.simular();
  }

  @Test
  public void testeMago()
      throws PersonagemJaEstaNoMapaException,
          PosicaoOcupadaException,
          SauronDominaOMundoException,
          PersonagemNaoEncontradoNoMapaException {
    Gandalf gandalf = new Gandalf();
    Saruman saruman = new Saruman();

    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(0, gandalf);
    mapa.inserir(9, saruman);
    simulador.simular();

    System.out.println(mapa.exibir());
  }

  @Test
  public void testeArqueiro()
      throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException {
    Legolas legolas = new Legolas();
    Goblim goblim = new Goblim();

    Mapa mapa = new Mapa();
    Simulador simulador = new Simulador(mapa);

    mapa.inserir(0, legolas);
    mapa.inserir(9, goblim);
    simulador.simular();

    System.out.println(mapa.exibir());
  }
}
