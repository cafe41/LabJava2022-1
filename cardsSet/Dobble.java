package cardsSet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Dobble {
    private ArrayList<Card> cardsSet;
    private int orden;
    private int numeroElementos;
    private int cantCartas;

    //Constructor
    public Dobble(List<String> elementos, int numE, int maxC) {
        //Inicializamos cardsSet y "n"
        ArrayList<Card> cardsSet = null; 
        int n;
        //Asignamos valor a "n", que será el orden
        if (numE > 0) {
            n = numE - 1;
        }
        else { //Esto es un caso muy raro, pero si llega a ocurrir, sacará un "n" aproximado de maxC
            int a = 1; int b = 1; int c; int n2;
            c = 1 - maxC;
            int sqrt = (int) sqrt(b * b - 4 * a * c);
            n =  ((-b + sqrt)/2);
            n2 = ((-b - sqrt)/2);
            if (n2 > n) {n = n2;}
        }
        //Ciclos
        if (maxC > 0) { //Si el usuario pidió más de 0 cartas (lol)
            //Para la primera carta:
            Card1 carta1 = new Card1(elementos, n);
            cardsSet.add(carta1);
            if (maxC > 1){
                //Para la "n" cantidad de cartas:
                for (int j = 1; j <= n; j++) {
                    CardN cartaN = new CardN(elementos, n, j);
                    cardsSet.add(cartaN);
                }
                //Para la "n cuadrado" cantidad de cartas:
                for (int i = 1; i <= n; i++){
                    for (int j = 1; j <= n; j++){
                        CardN2 cartaN2 = new CardN2(elementos, n, i, j);
                        cardsSet.add(cartaN2);
                    }
                }
            }
        }
        this.cardsSet = cardsSet;
        this.orden = n;
        this.numeroElementos = numE;
        this.cantCartas = maxC;
    }

    //Getters
    public ArrayList<Card> getCardsSet() {
        return cardsSet;
    }
    public int getOrden() {
        return orden;
    }
    public int getNumeroElementos() {
        return numeroElementos;
    }
    public int getCantCartas() {
        return cantCartas;
    }

    //No veo necesario los setters (aún)

    //dobbleValido (dobble?), método que verifica si es válido el cardsSet
    //DOM: cardsSet (ArrayList<Card>)
    //REC: boolean
    boolean dobbleValido(ArrayList<Card> cardsSet){
        ArrayList<String> listaElementos = null; //Se creará una lista donde irán todos los elementos
        //Si al final la lista queda con elementos, significa que hay cartas que tienen elementos
        for (int i = 0; i < cardsSet.size(); i++) {
            for (int j = 0; j < numeroElementos; j++) {
                if (!(listaElementos.contains(cardsSet.get(i).getElemento(j))))
                    //si no contiene el elemento de la carta, lo agrega
                    listaElementos.add(cardsSet.get(i).getElemento(j));
            }
        }
        //Segunda parte: Revisará carta por carta, como si jugara "Dobble".
        //Si la carta contiene el elemento, este se eliminará de la lista.
        for (int i = 0; i < cardsSet.size(); i++) {
            for (int j = 0; j < numeroElementos; j++) {
                for (int k = 0; k < numeroElementos; k++){
                    if (cardsSet.get(i).getElemento(j) == listaElementos.get(k)){
                        listaElementos.remove(k);
                    }
                }
            }
        }
        //Tercera parte: comprueba que no quede nada en la lista, si queda retornará false, sino true
        if (listaElementos.size() == 0) {
            System.out.println("El conjunto de cartas es válido\n");
            return true;
        }
        else {
            System.out.println("El conjunto de cartas no es válido\n");
            return false;
        }
    }

    //ultimaCarta (Obtener n-ésima carta), función que obtiene la última carta del cardsSet
    //interpreto la n-ésima carta, como la última carta de un conjunto de "n" cartas
    Card ultimaCarta(){
        Card nCarta= cardsSet.get(cardsSet.size()); //Asumiendo que el cardsSet no está vacío
        return nCarta;
    }




}
