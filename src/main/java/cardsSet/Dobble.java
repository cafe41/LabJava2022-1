package cardsSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.sqrt;

public class Dobble {
    private List<Card> cardsSet;
    private int orden;
    private int numeroElementos;
    private int cantMaxCartas;
    private List<String> listaElementos; //Decidí guardar la lista de elementos para usos futuros

    //Constructor
    //DOM: List<String> X int X int
    //REC: Dobble
    public Dobble(List<String> elementos, int numE, int maxC) {
        //Inicializamos cardsSet y "n"
        List<Card> cardsSet = new ArrayList<>();
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
            Card carta1 = new Card(elementos, n);
            cardsSet.add(carta1);
            if (maxC > 1){
                //Para la "n" cantidad de cartas:
                for (int j = 1; j <= n; j++) {
                    Card cartaN = new Card(elementos, n, j);
                    cardsSet.add(cartaN);
                }
                //Para la "n cuadrado" cantidad de cartas:
                for (int i = 1; i <= n; i++){
                    for (int j = 1; j <= n; j++){
                        Card cartaN2 = new Card(elementos, n, i, j);
                        cardsSet.add(cartaN2);
                    }
                }
            }
        }
        this.cardsSet = cardsSet;
        this.orden = n;
        this.numeroElementos = numE;
        this.cantMaxCartas = maxC;
        this.listaElementos = elementos;
    }
    //"Constructor" En caso de que necesite ser definido desde otro cardsSet
    public Dobble(List<Card> cardsSetAjeno, Dobble otroDobble) {
        this.cardsSet = cardsSetAjeno;
        this.orden = otroDobble.getOrden();
        this.numeroElementos = otroDobble.getNumeroElementos();
        this.cantMaxCartas = otroDobble.getCantMaxCartas();
        this.listaElementos = otroDobble.getListaElementos();
    }

    //Getters
    public List<Card> getCardsSet() {return cardsSet;}
    public int getOrden() {return orden;}
    public int getNumeroElementos() {return numeroElementos;}
    public int getCantMaxCartas() {return cantMaxCartas;}
    public List<String> getListaElementos() {return listaElementos;}

    //Setters
    public void setCardsSet(ArrayList<Card> cardsSet) {
        this.cardsSet = cardsSet;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }
    public void setCantCartas(int cantCartas) {
        this.cantMaxCartas = cantCartas;
    }

    //dobbleValido (dobble?), método que verifica si es válido el cardsSet
    //DOM: cardsSet (ArrayList<Card>)
    //REC: boolean
    public boolean dobbleValido(){
        List<String> listaElementos = new ArrayList<>(); //Se creará una lista donde irán todos los elementos
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
                for (int k = 0; k < listaElementos.size(); k++) {
                    if (Objects.equals(cardsSet.get(i).getElemento(j), listaElementos.get(k))) {
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

    //ultimaCarta (Obtener n-ésima carta), método que obtiene la última carta del cardsSet
    //interpreto la n-ésima carta, como la última carta de un conjunto de "n" cartas
    Card ultimaCarta(){
        //Asumiendo que el cardsSet no está vacío
        return cardsSet.get(cardsSet.size()-1);
    }

    //toString, método que devuelve "Dobble" como string
    //DOM: VOID
    //REC: String
    @java.lang.Override
    public java.lang.String toString() {
        return "\n" +
                "cardsSet = " + cardsSet + "\n" +
                "orden = " + orden + "\n" +
                "numeroElementos = " + numeroElementos + "\n" +
                "cantMaxCartas = " + cantMaxCartas + "\n";
    }

    //recortarSet, método que toma el cardsSet y le resta "n" cantidad de elementos, para que cumpla cierto largo
    //DOM: int
    //REC: List<Card>
    public List<Card> recortarSet(int n){
        List<Card> cardsSetNuevo = new ArrayList<Card>();
        for (int i = 0; i < n; i++){
            cardsSetNuevo.add(getCardsSet().get(i));
        }
        return cardsSetNuevo;
    }

    //missingCards, método que retornará las cartas que le faltan al cardsSet
    //DOM: Dobble
    //REC: List<Card> (cardsSet)
    public List<Card> missingCards(Dobble setOriginal){
        if (cardsSet == setOriginal.getCardsSet()){
            return null;
        }
        else {
            List<Card> cartasPerdidas = new ArrayList<>();
            //Ciclo que "restará" el set de cartas original al set de cartas actual
            for (int i = 0; i < setOriginal.getCardsSet().size(); i++){
                //Si el setCartas NO contiene una carta del setOriginal:
                if (!(cardsSet.contains(setOriginal.getCardsSet().get(i)))){
                    cartasPerdidas.add(setOriginal.getCardsSet().get(i));
                }
            }
            return cartasPerdidas;
        }
    }
}
