package dominio.PersonalYPasajeros;

import dominio.VueloYEtc.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tripulacion {

    /** Atributos **/

    private List<Vuelo> vuelos;
    private List<Personal> personal;

    /** Constructor **/

    public Tripulacion() {
        this.vuelos = new ArrayList<Vuelo>();
        this.personal = new ArrayList<Personal>();
    }

    /** Setters & Getters **/
    /** Métodos **/

    // Métodos por los requerimientos

    public Integer cantPersonal(){
        return personal.size();
    }

    public Integer cantVuelosQueRealizasteEntre ( LocalDate fecha1, LocalDate fecha2){
        return null;
    }

    //Métodos para agregar registros a los atributos

    public void agregarPersonal(Personal ... personal){
        Collections.addAll(this.personal, personal);
    }

    public void agregarVuelo(Vuelo unVuelo){
        this.vuelos.add(unVuelo);
    }
}
