import cardsSet.Dobble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Bienvenido al programa para crear cartas");
        //elementos
        System.out.print("Introduzca la cantidad de elementos que desea: ");
        int cantE = entradaEscaner.nextInt();
        //System.out.println("cantE = " + cantE);
        System.out.println("Escriba los elementos que desea agregar:");
        List<String> elementos = new ArrayList<>();
        Scanner elemento = new Scanner(System.in);
        for (int i = 0; i < cantE; i++){
            elementos.add(elemento.next());
        }
        System.out.println("La lista con " + cantE + " elementos es:\n" + elementos);
        //numE
        System.out.print("Introduzca el número de Elementos para una carta: ");
        int numE = entradaEscaner.nextInt();
        //System.out.println("numE = " + numE);
        //maxC
        System.out.print("Introduzca el número de Cartas: ");
        int maxC = entradaEscaner.nextInt();
        //System.out.println("maxC = " + maxC);
        //Creamos un set de cartas:
        Dobble setCartas = new Dobble(elementos, numE, maxC);
        System.out.println("El Dobble creado es:" + setCartas);
    }
}