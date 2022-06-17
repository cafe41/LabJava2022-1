package game;

import cardsSet.Dobble;

import java.util.ArrayList;
import java.util.List;

public class DobbleGame {
    List<Player> jugadores;
    int turnoActual; //index de la posición del jugador cuyo turno es
    Dobble mazoCartas;
    Dobble mazoIdeal;
    String modoDeJuego;

    //Constructor
    public DobbleGame() {
        this.jugadores = new ArrayList<>();
        this.turnoActual = 0;
    }

    //Getters
    public List<Player> getJugadores() {return jugadores;}
    public int getTurnoActual() {return turnoActual;}
    public int getCantidadJugadores() {return jugadores.size();}
    public Dobble getMazoCartas() {return mazoCartas;}
    public Dobble getMazoIdeal() {return mazoIdeal;}
    public String getModoDeJuego() {return modoDeJuego;}

    //Setters
    public void setTurnoActual(int turno) {this.turnoActual = turno;}
    public void setMazoCartas(Dobble mazoCartas) {this.mazoCartas = mazoCartas;}
    public void setMazoIdeal(Dobble mazoIdeal) {this.mazoIdeal = mazoIdeal;}
    public void setModoDeJuego(String modoDeJuego) {this.modoDeJuego = modoDeJuego;}

    //Otros métodos:

    //avanzarTurno, método que avanza el turno.
    //DOM: void
    //REC: void
    public void avanzarTurno(){
        if (turnoActual < getCantidadJugadores()) {
            this.turnoActual = turnoActual + 1;
        }
        else  {turnoActual = 0;} //Si el turno actual es el del último jugador, se reinicia
    }

    //obtenerPuntajes, método que obtiene una lista con los puntajes
    //DOM: void
    //REC: List<Integer>
    public List<Integer> obtenerPuntajes(){
        List<Integer> listaPuntajes = new ArrayList<>();
        for (int i=0; i < getJugadores().size(); i++){
            listaPuntajes.add(getJugadores().get(i).getPuntaje());
        }
        return listaPuntajes;
    }

    //puntajeMayor, método que obtiene el mayor de los puntajes
    //DOM: void
    //REC: Integer
    public Integer puntajeMayor(){
        int puntajeMayor = 0;
        for (int i=0;i < getJugadores().size();i++){
            if (puntajeMayor < obtenerPuntajes().get(i)){
                puntajeMayor = obtenerPuntajes().get(i);
            }
        }
        return puntajeMayor;
    }

    //vaGanando, método que entrega el nombre del jugador que va ganando
    //DOM: void
    //REC: String
    public String vaGanando(){
        String vaGanando = "Nadie";
        Integer puntajeMayor = 0;
        for (int i=0;i < getJugadores().size();i++){
            if (puntajeMayor < obtenerPuntajes().get(i)){
                puntajeMayor = obtenerPuntajes().get(i);
                vaGanando = getJugadores().get(i).getUser();
            }
        }
        return vaGanando;
    }
}
