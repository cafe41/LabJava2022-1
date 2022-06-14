package cardsSet;

import java.util.List;

public abstract class Card {
    private List<String> carta;

    public String getElemento(int n) {
            String elemento = carta.get(n);
        return elemento;
    }

    @Override
    public String toString() {
        return "[" + carta + ']';
    }
}