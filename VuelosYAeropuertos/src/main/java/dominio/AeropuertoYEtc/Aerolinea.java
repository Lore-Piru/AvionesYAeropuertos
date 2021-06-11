package dominio.AeropuertoYEtc;

import dominio.VueloYEtc.Vuelo;

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

    public Integer cantidadDePasajerosQueLlegaronEn(Integer unAnio, Integer unMes){
        List<Vuelo> vuelosEnEseMes =
                this.vuelos.stream().filter(a -> a.fechaAproxLlegada().getYear()==unAnio &&
                        a.fechaAproxLlegada().getMonthValue() == unMes).collect(Collectors.toList());
        return vuelosEnEseMes.stream().mapToInt(pasajeros -> pasajeros.cantidadDePasajeros()).sum();
    }

    public void agregarVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
