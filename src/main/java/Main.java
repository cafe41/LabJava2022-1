import cardsSet.Dobble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Bienvenido al programa para crear cartas" + "\n"
                + "Se le pedirá un orden, en base a este orden se generarán "
                + "cartas y una cantidad de elementos");
        //elementos
        System.out.print("\nIngrese el orden que desea: ");
        int orden = entradaEscaner.nextInt();
        int numE = orden + 1;              //Número de elementos en una carta
        int maxC = (orden * orden) + numE; //Número máximo de cartas a crear
        int cantE = maxC * numE;           //Número de elementos que debe agregar al usuario (if custom = true)
        System.out.println("Número de elementos en una carta = " + numE);
        System.out.println("Número de cartas a crear = " + maxC);
        System.out.println("Se requiere una cantidad de " + cantE + " elementos para crear las cartas" +
                "\n" + "Escriba los elementos que desea agregar:");
        List<String> elementos = new ArrayList<>();
        Scanner elemento = new Scanner(System.in);
        for (int i = 0; i < cantE; i++){
            elementos.add(elemento.next());
        }
        System.out.println("La lista con " + cantE + " elementos es:\n" + elementos);

        //Creamos un set de cartas:
        Dobble setCartas = new Dobble(elementos, numE, maxC);
        System.out.println("El Dobble creado es:" + setCartas);
    }
}