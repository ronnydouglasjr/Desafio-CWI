public class Orc extends Guerreiro implements Monstro{
    public Orc() {
        super("Orc", 7 ,4,1,30, true);
    }

    @Override
    public String grunhido() {
        return "Arrrggghhh";
    }

    public String toString(){
        return "O";
    }
}
