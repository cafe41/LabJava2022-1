package cardsSet;

import java.util.ArrayList;
import java.util.List;

public class CardN extends Card {
    private List<String> carta;

    //"Constructor"
    public CardN(List<String> elementos, int n, int j) { // n = orden, debe ser un número primo
        //Inicializamos variables
        ArrayList<String> cartaN = null;
        //Ciclo para crear una cartaN
        cartaN.add(elementos.get(1));
        for (int k=1; k<=n; k++) {
            cartaN.add(elementos.get(n * j + (k+1)));
        }
        this.carta = cartaN;
    }

    public List<String> getCarta() {
        return carta;
    }
}
