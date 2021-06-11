package dominio;

import dominio.AeropuertoYEtc.*;
import dominio.PersonalYPasajeros.*;
import dominio.PersonalYPasajeros.Persona.*;
import dominio.VueloYEtc.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDateTime;

public class TripulacionTest {
    //Creo las variables que luego serán objetos

    //Personal
    private Personal piloto;
    private Personal asistenteDeVuelo;

    //Tripulacion
    private Tripulacion tripulacion1;

    //Vuelos
    private Vuelo vueloAB;

    //Tiempo
    private LocalDateTime fechaHoraSalidaVueloAB = LocalDateTime.now();

    @Before
    public void inicializacionDeTodo(){
        //Personal
        this.piloto = new Personal(Cargo.PILOTO);
        this.asistenteDeVuelo = new Personal(Cargo.ASISTENTE_DE_VUELO);

        //Tripulacion
        this.tripulacion1 = new Tripulacion();
        this.tripulacion1.agregarPersonal(piloto, asistenteDeVuelo);

        //Vuelos
        this.vueloAB = new Vuelo();

        //Seteo lo que voy a usar de vuelo
        this.vueloAB.setFechaYHoraDeSalida(this.fechaHoraSalidaVueloAB);
        this.vueloAB.setDuracionVueloAproxEnMins(150);

        //Agrego el vuelo a la tripulación
        this.tripulacion1.agregarVuelo(this.vueloAB);
    }

    @Test
    public void cuantoPersonalHay(){
        Assert.assertEquals(2, this.tripulacion1.cantPersonal().intValue());
    }

    @Test
    public void cantidadDeVuelosRealizadosEntre(){

    }
}
