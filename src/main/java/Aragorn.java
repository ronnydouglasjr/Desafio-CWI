public class Aragorn extends Guerreiro implements Humano{

    public Aragorn() {
        super("Aragorn", 10, 7, 6, 60, true);
    }

    public String falar(){
       return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public void envelhecer (){
        setConstituicao(getConstituicao() - 1);
    }

    public String toString() {
        return "A";
    }
}
