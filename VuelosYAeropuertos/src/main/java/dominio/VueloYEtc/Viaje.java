package dominio.VueloYEtc;

import dominio.PersonalYPasajeros.Pasajero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Viaje {

    /** Atributos **/
    private List<Escala> escalas;
    private List<Vuelo> vuelos;

    /** Constructor **/
    public Viaje() {
        this.escalas = new ArrayList<Escala>();
        this.vuelos = new ArrayList<Vuelo>();
    }

    /** Setters & Getters **/

    /** Métodos **/
    // Métodos por los requerimientos

    public Integer getDuracionTotalAproxEnMins() {
        return (this.getDuracionDeTodasLasEscalas() + this.getDuracionDeTodasLosVuelos());
    }

    public Integer getDuracionDeTodasLasEscalas() {
        return this.escalas.stream().mapToInt(escalas -> escalas.getDuracionEscalaAproxEnMins()).sum();
    }
    public Integer getDuracionDeTodasLosVuelos() {
        return this.vuelos.stream().mapToInt(vuelos -> vuelos.getDuracionVueloAproxEnMins()).sum();
    }

    //Métodos para agregar registros a los atributos

    private void agregarEscalas(Escala ... unasEscalas){
        Collections.addAll(this.escalas, unasEscalas);
    }

    public void agregarVuelos(Vuelo... unosVuelos){
        Collections.addAll(this.vuelos, unosVuelos);
    }

}
