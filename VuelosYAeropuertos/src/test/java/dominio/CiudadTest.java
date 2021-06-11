package dominio;

import dominio.AeropuertoYEtc.Aeropuerto;
import dominio.AeropuertoYEtc.Ciudad;
import dominio.PersonalYPasajeros.Pasajero;
import dominio.VueloYEtc.Vuelo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CiudadTest{
    //Creo las variables que luego serán objetos

    //Ciudades
    private Ciudad ciudadA;
    private Ciudad ciudadB;
    private Ciudad ciudadD;

    private List<Ciudad> ciudades;

    //Aeropuertos
    private Aeropuerto aeropuertoA;
    private Aeropuerto aeropuertoB;
    private Aeropuerto aeropuertoC;
    private Aeropuerto aeropuertoD;

    //Pasajeros
    private Pasajero pasajero1;
    private Pasajero pasajero2;
    private Pasajero pasajero3;
    private Pasajero pasajero4;

    //Vuelos
    private Vuelo vueloAB;
    private Vuelo vueloBA;
    private Vuelo vueloCD;

    //Tiempo
    private LocalDateTime fechaHoraSalidaVueloAB =
            LocalDateTime.of(2021, 6, 11, 4, 04, 00);
    private LocalDateTime fechaHoraSalidaVueloBA =
            LocalDateTime.of(2021, 6, 11, 4, 04, 00);
    private LocalDateTime fechaHoraSalidaVueloCD =
            LocalDateTime.of(2021, 6, 8, 4, 04, 00);

    @Before
    public void inicializacionDeTodo(){
        //En este punto voy inicializar esas variables como instancias de las clases correspondientes.

        //Ciudades
        this.ciudadA = new Ciudad();
        this.ciudadB = new Ciudad();
        this.ciudadD = new Ciudad();

        //Aeropuertos
        this.aeropuertoA = new Aeropuerto();
        this.aeropuertoB = new Aeropuerto();
        this.aeropuertoC = new Aeropuerto();
        this.aeropuertoD = new Aeropuerto();

        //Agrego los aeropuertos a las ciudades
        this.ciudadA.agregarAeropuertos(this.aeropuertoA);
        this.ciudadB.agregarAeropuertos(this.aeropuertoB, this.aeropuertoC);
        this.ciudadD.agregarAeropuertos(this.aeropuertoD);

        //Pasajeros
        this.pasajero1 = new Pasajero();
        this.pasajero2 = new Pasajero();
        this.pasajero3 = new Pasajero();
        this.pasajero4 = new Pasajero();

        //Vuelos
        this.vueloAB = new Vuelo();
        this.vueloBA = new Vuelo();
        this.vueloCD = new Vuelo();

        //Seteo lo que voy a usar de vuelo
        this.vueloAB.setFechaYHoraDeSalida(this.fechaHoraSalidaVueloAB);
        this.vueloAB.setDuracionVueloAproxEnMins(150);
        this.vueloAB.setDestino(aeropuertoB);
        this.vueloAB.agregarPasajeros(this.pasajero1, this.pasajero2, this.pasajero3, this.pasajero4);

        this.vueloBA.setFechaYHoraDeSalida(this.fechaHoraSalidaVueloBA);
        this.vueloBA.setDuracionVueloAproxEnMins(150);
        this.vueloBA.setDestino(aeropuertoA);
        this.vueloBA.agregarPasajeros(this.pasajero1, this.pasajero2);

        this.vueloCD.setFechaYHoraDeSalida(this.fechaHoraSalidaVueloCD);
        this.vueloCD.setDuracionVueloAproxEnMins(150);
        this.vueloCD.setDestino(aeropuertoD);
        this.vueloCD.agregarPasajeros(this.pasajero1, this.pasajero2, this.pasajero3, this.pasajero4);

        //Instancio la colección de Ciudades
        this.ciudades = new ArrayList<Ciudad>();
        this.ciudades.add(ciudadA);
        this.ciudades.add(ciudadB);
        this.ciudades.add(ciudadD);
    }


    @Test
    public void cantidadDeAeropuertos(){
        Assert.assertEquals(2, this.ciudadB.cantDeAeropuertos().intValue());
    }

    @Test
    public void cantidadDePasajerosQueLlegaronEn(){
        LocalDate fechaAComparar = LocalDate.of(2021, 6, 11);
        Assert.assertEquals(4, this.ciudadB.cantidadDePasajerosQueLlegaronEn(fechaAComparar).intValue());
    }

    @Test
    public void ciudadConMasPasajerosEnUnDia(){
        LocalDate fechaAComparar = LocalDate.of(2021, 6, 11);
        Ciudad ciudadConMasPasajerosEnEseDia = Collections.max(ciudades, new Comparator<Ciudad>(){
            public int compare(Ciudad a, Ciudad b) {
                return Integer.compare(a.cantidadDePasajerosQueLlegaronEn(fechaAComparar).intValue(),
                        b.cantidadDePasajerosQueLlegaronEn(fechaAComparar).intValue());
            }
        });
        Assert.assertSame(this.ciudadB, ciudadConMasPasajerosEnEseDia);
    }
}
