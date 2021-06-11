package dominio;

import dominio.AeropuertoYEtc.*;
import dominio.PersonalYPasajeros.*;
import dominio.PersonalYPasajeros.Persona.*;
import dominio.VueloYEtc.*;

import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.format.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class VueloTest {
    //Creo las variables que luego serán objetos

    //Personal
    private Personal piloto;
    private Personal asistenteDeVuelo;

    //Tripulacion
    private Tripulacion tripulacion1;

    //Pasajeros
    private Pasajero pasajero1;
    private Pasajero pasajero2;
    private Pasajero pasajero3;
    private Pasajero pasajero4;

    //Aviones
    private Avion avion1;

    //Vuelos
    private Vuelo vueloAB;

    //Aerolineas
    private Aerolinea aerolinea1;

    //Tiempo
    private LocalDateTime fechaHoraSalidaVueloAB =
            LocalDateTime.of(2021, 6, 11, 4, 04, 00);


    @Before
    public void inicializacionDeTodo(){

        //Personal
        this.piloto = new Personal(Cargo.PILOTO);
        this.asistenteDeVuelo = new Personal(Cargo.ASISTENTE_DE_VUELO);

        //Tripulacion
        this.tripulacion1 = new Tripulacion();
        this.tripulacion1.agregarPersonal(piloto, asistenteDeVuelo);

        //Pasajeros
        this.pasajero1 = new Pasajero();
        this.pasajero2 = new Pasajero();
        this.pasajero3 = new Pasajero();
        this.pasajero4 = new Pasajero();

        //Vuelos
        this.vueloAB = new Vuelo();


        //Aerolineas
        this.aerolinea1 = new Aerolinea("Aerolinea1");

        //Aviones
        this.avion1 = new Avion(252, aerolinea1);

        //Seteo lo que voy a usar de vuelo
        this.vueloAB.setFechaYHoraDeSalida(this.fechaHoraSalidaVueloAB);
        this.vueloAB.setDuracionVueloAproxEnMins(50);
        this.vueloAB.setAvion(this.avion1);
        this.vueloAB.setTripulacion(this.tripulacion1);
        this.vueloAB.agregarPasajeros(this.pasajero1, this.pasajero2, this.pasajero3, this.pasajero4);
    }

    @Test
    public void obtenerCapacidadOcupada(){
        //(this.pasajeros.size()*100)/(this.avion.getCantAsientosTotales() - this.tripulacion.cantPersonal());
        Assert.assertEquals(1.6, this.vueloAB.getCapacidadOcupada(),0);
    }

    @Test
    public void obtenerFechaHoraDeLLegada(){
        LocalDateTime fechaYHoraAcomparar =
                LocalDateTime.of(2021, 6, 11, 4, 54, 00);
        Assert.assertTrue(this.vueloAB.fechaHoraAproxLlegada().isEqual(fechaYHoraAcomparar));
    }

    //Aerolinea Test
    @Test
    public void cantidadDePasajerosEn(){
        Assert.assertEquals(4 , this.aerolinea1.cantidadDePasajerosQueLlegaronEn(2021,6).intValue());
    }

}
