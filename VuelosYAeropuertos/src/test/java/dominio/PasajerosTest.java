package dominio;

import dominio.AeropuertoYEtc.*;
import dominio.PersonalYPasajeros.*;
import dominio.PersonalYPasajeros.Persona.*;
import dominio.VueloYEtc.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class PasajerosTest {
    //Creo las variables que luego serán objetos

    //Ciudades
    private Ciudad ciudadA;
    private Ciudad ciudadB;

    //Aeropuertos
    private Aeropuerto aeropuertoA;
    private Aeropuerto aeropuertoB;

    //Pasajeros
    private Pasajero pasajero1;

    //Vuelos
    private Vuelo vueloAB;

    @Before
    public void inicializacionDeTodo(){
        //En este punto voy inicializar esas variables como instancias de las clases correspondientes.

        //Ciudades
        this.ciudadA = new Ciudad();
        this.ciudadB = new Ciudad();

        //Aeropuertos
        this.aeropuertoA = new Aeropuerto();
        this.aeropuertoB = new Aeropuerto();

        //Agrego los aeropuertos a las ciudades
        this.ciudadA.agregarAeropuertos(this.aeropuertoA);
        this.ciudadB.agregarAeropuertos(this.aeropuertoB);

        //Pasajeros
        this.pasajero1 = new Pasajero();

        //Vuelos
        this.vueloAB = new Vuelo();

        //Seteo lo que voy a usar de vuelo
        this.vueloAB.setOrigen(this.aeropuertoA);
        this.vueloAB.setDestino(this.aeropuertoB);
        this.vueloAB.agregarPasajeros(this.pasajero1);
    }

    @Test
    public void cuantasVecesVisitasteCiudadB(){
        this.pasajero1.agregarVuelo(this.vueloAB);
        //De esta manera debería haber visitado 2 veces ciudadB
        Assert.assertEquals(2, this.pasajero1.cantidadDeVecesQueVisitaste(this.ciudadB).intValue());
    }
    @Test
    public void cuantasVuelosHiciste(){
        this.pasajero1.agregarVuelo(this.vueloAB);
        //De esta manera debería haber hecho 2 vuelos
        Assert.assertEquals(2, this.pasajero1.cantVuelosRealizados().intValue());
    }
}
