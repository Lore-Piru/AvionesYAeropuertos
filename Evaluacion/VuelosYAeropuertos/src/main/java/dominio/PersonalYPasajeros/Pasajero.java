package dominio.PersonalYPasajeros;

import dominio.PersonalYPasajeros.Persona.Persona;
import dominio.VueloYEtc.Vuelo;
import dominio.AeropuertoYEtc.Ciudad;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Pasajero extends Persona {

    /** Atributos **/
    private List<Vuelo> vuelos;

    /** Constructor **/
    public Pasajero() {
        this.vuelos = new ArrayList<Vuelo>();
    }

    /** Setters & Getters **/

    /** Métodos **/

    // Métodos por los requerimientos
    public Integer cantidadDeVecesQueVisitaste (Ciudad ciudad){
        return this.vuelos.stream().filter(a -> a.getDestino().getCiudad()==ciudad).collect(Collectors.toList()).size();
    }

    public Integer cantVuelosRealizados () {
        return vuelos.size();
    }

    //Métodos para agregar registros a los atributos

    public void agregarVuelo(Vuelo unVuelo){
        this.vuelos.add(unVuelo);
    }
}
