import classes.Urukhai;
import org.junit.Assert;
import org.junit.Test;

public class UrukhaiTest {
  @Test
  public void grunhidoDeUrukhai() {
    Urukhai urukhai = new Urukhai();

    String grunhidoEsperado = "Uuurrrrrr";

    Assert.assertEquals(grunhidoEsperado, urukhai.grunhido());
  }

  @Test
  public void UrukhaiFala() {
    Urukhai urukhai = new Urukhai();

    String falaEsperada = "Looks like meat's back on the menu boys!";

    Assert.assertEquals(falaEsperada, urukhai.falar());
  }

  @Test
  public void UrukhaiEnvelheceETemDanoMenosDoisDeVida() {
    // Constituicão inicial =  45
    Urukhai urukhai = new Urukhai();

    urukhai.envelhecer();
    urukhai.envelhecer();
    urukhai.envelhecer();

    int constituicaoEsperada = 39;

    Assert.assertEquals(constituicaoEsperada, urukhai.getConstituicao());
  }
}
