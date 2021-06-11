package dominio.AeropuertoYEtc;

import dominio.VueloYEtc.Vuelo;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Aerolinea {

    /** Atributos **/
    private String nombre;
    private List<Vuelo> vuelos;

    /** Constructor **/
    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<Vuelo>();
    }

    /** Setters & Getters **/

    /** Métodos **/
    public Integer cantPasajerosEn(Integer unAnio, Integer unMes){

        this.vuelos.stream().filter(a -> a.fechaAproxLlegada().getYear()==unAnio
                            && a.fechaHoraAproxLlegada().getMonthValue() == unMes).collect(Collectors.toList()).size();
        return null;
    }

    public Integer cantidadDePasajerosQueLlegaronEn(Integer unMes){
        List<Vuelo> vuelosEnEseDia =
                this.vuelos.stream().filter(a -> a.fechaAproxLlegada().getMonthValue() == unMes).collect(Collectors.toList());
        return vuelosEnEseDia.stream().mapToInt(pasajeros -> pasajeros.cantidadDePasajeros()).sum();
    }

    public void agregarVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
