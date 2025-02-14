import classes.Aragorn;
import org.junit.Assert;
import org.junit.Test;

public class AragornTest {

  @Test
  public void AragornFalar() {
    Aragorn aragorn = new Aragorn();
    String falaEsperada = "A day may come when the courage of men fails… but it is not THIS day.";

    Assert.assertEquals(falaEsperada, aragorn.falar());
  }

  @Test
  public void aragornEnvelheceETemDanoDeVidaMenosUm() {
    // Constituição inicial = 60
    Aragorn aragorn = new Aragorn();

    aragorn.envelhecer();
    aragorn.envelhecer();
    aragorn.envelhecer();

    int constituicaoEsperada = 57;

    Assert.assertEquals(constituicaoEsperada, aragorn.getConstituicao());
  }
}
