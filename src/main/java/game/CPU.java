package game;

import java.util.List;

public class CPU implements Player {
    private String user;  //Ej: "CPU 1"
    private int nJugador; //EJ: 2 [jugador1, cpu1]
    private boolean CPU;  //CPU: true
    private int puntaje;  //EJ: 29

    public CPU(String user, List<Player> jugadores) {
        this.nJugador = jugadores.size() + 1;
        this.user = "CPU";
        this.CPU = true;
        this.puntaje = 0;
    }

    //Setters: solo el nombre del CPU y el puntaje deberían poder cambiarse
    public void setUser(String user) {this.user = user;}
    public void setPuntaje(int puntaje) {this.puntaje = puntaje;}

    //Getters:
    public String getUser() {return user;}
    public int getNumeroJugador() {return nJugador;}
    public boolean isCPU() {return CPU;}
    public int getPuntaje() {return puntaje;}

    //Otros métodos

    //agregarPuntaje, método que agrega un puntaje "agregado" al puntaje.
    //DOM: int
    //REC: void
    public void agregarPuntaje(int agregado){
        setPuntaje(getPuntaje() + agregado);
    }
}
