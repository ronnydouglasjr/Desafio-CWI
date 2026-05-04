import classes.Gandalf;
import org.junit.Assert;
import org.junit.Test;

public class GandalfTest {
  @Test
  public void gandalfFalar() {
    Gandalf gandalf = new Gandalf();
    String falaEsperada =
        "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

    Assert.assertEquals(falaEsperada, gandalf.falar());
  }

  @Test
  public void gandalfRessucita() {
    Gandalf gandalf = new Gandalf();
    gandalf.setConstituicao(0);

    Gandalf novoGandalf = gandalf.ressuscitar();

    Assert.assertNotEquals(gandalf, novoGandalf);
  }
}
