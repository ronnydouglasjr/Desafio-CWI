import classes.Goblim;
import org.junit.Assert;
import org.junit.Test;

public class GoblimTest {
  @Test
  public void grunhidoDeGoblim() {
    Goblim goblim = new Goblim();

    String grunhidoEsperado = "Iiisshhhh";

    Assert.assertEquals(grunhidoEsperado, goblim.grunhido());
  }
}
