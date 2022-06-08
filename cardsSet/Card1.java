package cardsSet;

import java.util.ArrayList;
import java.util.List;

public class Card1 extends Card {
    private List<String> carta;

    //"Constructor"
    public Card1(List<String> elementos, int n) { // n = orden, debe ser un número primo
        //Inicializamos variables
        ArrayList<String> carta1 = null;
        //Ciclo para crear la carta1
        for (int i = 1; i <= n; i++) {
            carta1.add(elementos.get(i));
        }
        this.carta = carta1;
    }
}
