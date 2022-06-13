import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String entradaTeclado;
        System.out.println("Empezamos el programa");
        System.out.println("Por favor introduzca una cadena por teclado:");

        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner
        System.out.println("Entrada recibida por teclado es: \"" + entradaTeclado + "\"");
    }
}