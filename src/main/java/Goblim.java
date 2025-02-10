public class Goblim extends Arqueiro implements Monstro {
    public Goblim() {
        super("Goblim", 3,6,1,20,false);
    }

    @Override
    public String grunhido() {
        return "Iiisshhhh";
    }

    public String toString(){
        return "M";
    }
}
