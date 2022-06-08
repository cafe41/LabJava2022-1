package cardsSet;

import java.util.ArrayList;
import java.util.List;

public class CardN2 extends Card {
    private List<String> carta;

    //"Constructor"
    public CardN2(List<String> elementos, int n, int i, int j) { // n = orden, debe ser un número primo
        //Inicializamos variables
        ArrayList<String> cartaN2 = null;
        //Ciclo para crear una cartaN
        cartaN2.add(elementos.get(i+1));
        for (int k=1; k<=n; k++) {
            cartaN2.add(elementos.get(n+2+n*(k-1)+(((i-1)*(k-1)+j-1)%n)));
        }
        this.carta = cartaN2;
    }
}
