import classes.Orc;
import org.junit.Assert;
import org.junit.Test;

public class OrcTest {
  @Test
  public void grunhidoDeOrc() {
    Orc orc = new Orc();

    String gruinhidoEsperado = "Arrrggghhh";

    Assert.assertEquals(gruinhidoEsperado, orc.grunhido());
  }
}
