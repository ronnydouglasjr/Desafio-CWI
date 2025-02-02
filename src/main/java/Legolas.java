public class Legolas extends Guerreiro implements Elfo {
    public Legolas() {
        super("Legolas", 5, 10, 6, 80, true);
    }

    @Override
    public String fala() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String falarElfico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }

    public String toString(){
        return "L";
    }
}
