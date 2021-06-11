package dominio.AeropuertoYEtc;

import dominio.PersonalYPasajeros.Pasajero;
import dominio.VueloYEtc.Vuelo;

import java.time.LocalDate;
import java.time.format.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Ciudad {

    /** Atributos **/
    private String nombre;
    private List<Aeropuerto> aeropuertos;
    private List<Vuelo> vuelos;

    /** Constructores **/
    public Ciudad() {
        this.aeropuertos = new ArrayList<Aeropuerto>();
        this.vuelos = new ArrayList<Vuelo>();
    }

    /** Setters & Getters **/

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    /** Métodos **/

    // Métodos por los requerimientos
    public Integer cantDeAeropuertos(){
        return this.aeropuertos.size();
    }

    public Integer cantidadDePasajerosQueLlegaronEn(LocalDate unDia){
        List<Vuelo> vuelosEnEseDia =
                this.vuelos.stream().filter(a -> a.fechaAproxLlegada().equals(unDia)).collect(Collectors.toList());
        return vuelosEnEseDia.stream().mapToInt(pasajeros -> pasajeros.cantidadDePasajeros()).sum();
    }

    //Métodos para agregar registros a los atributos
    public void agregarAeropuertos(Aeropuerto... unosAeropuertos){
        Collections.addAll(this.aeropuertos, unosAeropuertos);
        for(Aeropuerto aeropuerto : unosAeropuertos){
            aeropuerto.setCiudad(this);
        }
    }

    public void agregarVueloQueLlego(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
