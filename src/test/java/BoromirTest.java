import classes.Boromir;
import org.junit.Assert;
import org.junit.Test;

public class BoromirTest {
    @Test
    public void boromirFala() {
        Boromir boromir = new Boromir();

        String falaEsperada = "One does not simply walk into Mordor.";

        Assert.assertEquals(falaEsperada, boromir.falar());
    }

    @Test
    public void borimirEnvelheceETemUmDanoMenosDois(){
        // constituição inicial 40
        Boromir boromir = new Boromir();

        int constituicaoEsperada = 30;

        boromir.envelhecer();
        boromir.envelhecer();
        boromir.envelhecer();
        boromir.envelhecer();
        boromir.envelhecer();

        Assert.assertEquals(constituicaoEsperada, boromir.getConstituicao());
    }
}
