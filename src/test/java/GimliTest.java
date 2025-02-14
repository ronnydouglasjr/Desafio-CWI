import classes.Gimli;
import org.junit.Assert;
import org.junit.Test;

public class GimliTest {
    @Test
    public void gimliBeberEFala(){
        Gimli gimli = new Gimli();

        String falandoSobrio = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

        Assert.assertEquals(falandoSobrio, gimli.falar());

        gimli.beber();
        gimli.beber();
        gimli.beber();

        String falandoBebado = "What did I say? He can't hold his liquor!";

        Assert.assertEquals(falandoBebado, gimli.falar());
    }
}
