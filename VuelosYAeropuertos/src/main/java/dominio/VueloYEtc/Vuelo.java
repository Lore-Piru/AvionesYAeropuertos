package dominio.VueloYEtc;

import dominio.PersonalYPasajeros.*;
import dominio.AeropuertoYEtc.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vuelo {

    /** Atributos **/
    private List<Pasajero> pasajeros;
    private Tripulacion tripulacion;
    private Avion avion;
    private Aeropuerto origen;
    private Aeropuerto destino;

    private Integer duracionVueloAproxEnMins;
    private LocalDateTime fechaYHoraDeSalida;

    /** Constructor **/
    //Creo 2 constructores, uno con pasajeros y el otro sin. Los demás valores deberán estar antes de crear el vuelo.

    public Vuelo() {
        this.pasajeros = new ArrayList<Pasajero>();
    }

    /** Setters & Getters **/

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
        this.tripulacion.agregarVuelo(this);
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
        agregarVueloAAerolinea();
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
        this.origen.agregarVueloQuePartio(this);
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
        this.destino.agregarVueloQueLlego(this);
    }

    public void setDuracionVueloAproxEnMins(Integer duracionVueloAproxEnMins) {
        this.duracionVueloAproxEnMins = duracionVueloAproxEnMins;
    }

    public void setFechaYHoraDeSalida(LocalDateTime fechaYHoraDeSalida) {
        this.fechaYHoraDeSalida = fechaYHoraDeSalida;
    }

    public Integer getDuracionVueloAproxEnMins() {
        return duracionVueloAproxEnMins;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    /** Métodos **/
    // Métodos por los requerimientos

    public  LocalDateTime fechaHoraAproxLlegada() {
        return fechaYHoraDeSalida.plusMinutes(duracionVueloAproxEnMins);
    }

    public void agregarVueloAAerolinea(){
        this.avion.getAerolinea().agregarVuelo(this);
    }

    public  LocalDate fechaAproxLlegada() {
        LocalDateTime fechaHoraAproxLlegada = fechaHoraAproxLlegada();
        LocalDate fechaAproxLlegada = LocalDate.of(fechaHoraAproxLlegada.getYear(),
                fechaHoraAproxLlegada.getMonth(), fechaHoraAproxLlegada.getDayOfMonth());
        return fechaAproxLlegada;
    }

    public Double getCapacidadOcupada() {
        /* El siguiente cálculo es una regla de 3 simple, donde hubo que hacer un poco de despeje. La regla sería así:
        A -> B
        X -> C
        X = (C * A) / B
        Pasado a valores:
        100 -> Cantidad de asientos ofrecidos (Que es = Cantidad de asientos - Cantidad de tripulación)
        X   -> Cantidad de pasajeros

        La primera vez usé variables intermedias, pero es innesesario y luego de comprobar el funcionamiento
        optimicé un poco la cuenta. */

        return (this.pasajeros.size()*100.0)/asientosOfrecidos();
    }

    private Double asientosOfrecidos(){
        return (this.avion.getCantAsientosTotales().doubleValue() - this.tripulacion.cantPersonal().doubleValue());
    }

    public Integer cantidadDePasajeros(){
        return this.pasajeros.size();
    }

    //Métodos para agregar registros a los atributos

    public void agregarPasajeros(Pasajero ... unosPasajeros){
        Collections.addAll(this.pasajeros, unosPasajeros);
        for(Pasajero pasajero : unosPasajeros){
            pasajero.agregarVuelo(this);
        }
    }
}
