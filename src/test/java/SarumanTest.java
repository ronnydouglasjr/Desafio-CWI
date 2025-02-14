import classes.Saruman;
import org.junit.Assert;
import org.junit.Test;

public class SarumanTest {
  @Test
  public void sarumanFala() {
    Saruman saruman = new Saruman();

    String falaEsperada = "Against the power of Mordor there can be no victory.";

    Assert.assertEquals(falaEsperada, saruman.falar());
  }

  @Test
  public void sarumanRessicita() {
    Saruman saruman = new Saruman();

    Assert.assertNull(saruman.ressuscitar());
  }
}
