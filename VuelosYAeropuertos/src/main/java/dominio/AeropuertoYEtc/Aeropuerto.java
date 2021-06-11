package dominio.AeropuertoYEtc;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import dominio.VueloYEtc.*;

public class Aeropuerto {

    /** Atributos **/
    private Integer escalasHechas;
    private Ciudad ciudad;
    private List<Vuelo> vuelosQuePartieron;
    private List<Vuelo> vuelosQueLlegaron;

    /** Constructor **/
    public Aeropuerto() {
        this.vuelosQuePartieron = new ArrayList<Vuelo>();
        this.vuelosQueLlegaron = new ArrayList<Vuelo>();
        this.escalasHechas = 0;
    }

    /** Setters & Getters **/

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    /** Métodos **/

    // Métodos por los requerimientos

    public Integer cantDeVuelosArrivadosComoEscalas() {
        return escalasHechas;
    }

    public Integer cantDeVuelosQueLlegaronEn(LocalDate unDia) {
        return this.vuelosQueLlegaron.stream().filter( a -> a.fechaAproxLlegada().equals(unDia)
                                                        ).collect(Collectors.toList()).size();
    }

    public Integer cantDeVuelosQuePartieronEn(LocalDate unDia) {
        return this.vuelosQuePartieron.stream().filter(a -> a.fechaAproxLlegada().equals(unDia)
                                                        ).collect(Collectors.toList()).size();
    }

    //Métodos para agregar registros a los atributos

    public void agregarVueloQuePartio(Vuelo unVuelo){
        this.vuelosQuePartieron.add(unVuelo);
    }

    public void agregarVueloQueLlego(Vuelo unVuelo){
        this.vuelosQueLlegaron.add(unVuelo);
        this.ciudad.agregarVueloQueLlego(unVuelo);
    }

    public void agregarUnaEscala(){
        this.escalasHechas ++;
    }
}
