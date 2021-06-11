package dominio.VueloYEtc;

import dominio.AeropuertoYEtc.Aeropuerto;

public class Escala {

    /**
     * Atributos
     **/
    private Aeropuerto aeropuerto;
    private Integer duracionEscalaAproxEnMins;

    /**
     * Constructor
     **/

    public Escala(Aeropuerto aeropuerto, Integer duracionEscalaAproxEnMins) {
        this.aeropuerto = aeropuerto;
        this.duracionEscalaAproxEnMins = duracionEscalaAproxEnMins;
        this.aeropuerto.agregarUnaEscala();
    }

    /**
     * Setters & Getters
     **/
    public Integer getDuracionEscalaAproxEnMins() {
        return duracionEscalaAproxEnMins;
    }

    /** Métodos **/

}
