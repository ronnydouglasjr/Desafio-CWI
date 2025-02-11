public class Gimli extends Guerreiro implements Anao {
  private int dose;

  public Gimli() {
    super("Gimli", 9, 2, 4, 60, true);
  }

  @Override
  public int beber() {
    return dose++;
  }

  @Override
  public String falar() {
    if (beber() >= 3) {
      return "What did I say? He can't hold his liquor!";
    }
    return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
  }

  public String toString() {
    return "I";
  }
}
