package game;

import java.util.List;

public class Humano implements Player {
    private String user;  //Ej: "Jugador1"
    private int nJugador; //EJ: 1 [jugador1, cpu1]
    private boolean CPU;  //CPU: true
    private int puntaje;  //EJ: 20

    public Humano(String user, List<Player> jugadores) {
        this.user = user;
        this.nJugador = jugadores.size() + 1;
        this.CPU = false;
        this.puntaje = 0;
    }

    //Setters: El nombre de usuario y el puntaje se pueden cambiar
    public void setUser(String user) {this.user = user;}
    public void setPuntaje(int puntaje) {this.puntaje = puntaje;}

    //Getters:
    public String getUser() {return user;}
    public int getNumeroJugador() {return nJugador;}
    public boolean isCPU() {return CPU;}
    public int getPuntaje() {return puntaje;}

    //Otros métodos:

    //agregarPuntaje, método que agrega un puntaje "agregado" al puntaje.
    //DOM: int
    //REC: void
    public void agregarPuntaje(int agregado){
        setPuntaje(getPuntaje() + agregado);
    }
}
