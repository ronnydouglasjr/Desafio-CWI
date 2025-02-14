import classes.Legolas;
import org.junit.Assert;
import org.junit.Test;

public class LegolasTest {
  @Test
  public void LegolasFalar() {
    Legolas legolas = new Legolas();

    String falaEsperada = "They're taking the Hobbits to Isengard!";
    String falaElficoEsperado =
        "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

    Assert.assertEquals(falaEsperada, legolas.falar());
    Assert.assertEquals(falaElficoEsperado, legolas.falarElfico());
  }
}
