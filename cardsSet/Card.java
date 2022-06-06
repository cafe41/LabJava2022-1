package cardsSet;

import java.util.ArrayList;
import java.util.List;

public abstract class Card {
    public List<Integer> Card = new ArrayList<>();
    public List<Integer> crearCarta;
}

private class Card1 extends Card {
    private Card1;
    private List<Integer> Card1(int numE, int maxC){
        Card1 carta1 = (Card1) crearCarta(numE, maxC);
        return (List<Integer>) carta1;
    }
    //"Constructor"
    private List<Integer> crearCarta(int numE, int maxC){
        Card1 carta1 = new ArrayList<>();
        return carta1;
    }
}