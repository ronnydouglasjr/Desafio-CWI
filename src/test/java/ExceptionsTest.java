import classes.Aragorn;
import classes.Legolas;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import org.junit.Assert;
import org.junit.Test;

public class ExceptionsTest {

    @Test(expected = PosicaoOcupadaException.class)
    public void deveLancarPosicaoOcupadaExceptionQuandoDoisPersonagensOcuparemMesmaPosicao()
            throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Mapa mapa = new Mapa();
        mapa.inserirPersonagem(0, aragorn);
        mapa.inserirPersonagem(0, legolas);
    }

    @Test
    public void deveLancarPersonagemJaEstaNoMapaException() {
        String mensagemEsperada = "Personagem já está no mapa!";
        Exception personagemJaEstaNoMapa = new PersonagemJaEstaNoMapaException(mensagemEsperada);
        Assert.assertEquals(mensagemEsperada, personagemJaEstaNoMapa.getMessage());
    }

    @Test
    public void deveLancarPersonagemNaoEstaNoMapaException() {
        String mensagemEsperada = "Personagem não encontrado no mapa!";
        Exception personagemNaoEncontrado = new PersonagemNaoEncontradoNoMapaException(mensagemEsperada);
        Assert.assertEquals(mensagemEsperada, personagemNaoEncontrado.getMessage());
    }

}
