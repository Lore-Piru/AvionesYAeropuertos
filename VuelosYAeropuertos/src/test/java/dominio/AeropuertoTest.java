package dominio;

import dominio.AeropuertoYEtc.*;
import dominio.VueloYEtc.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;

import java.util.*;

public class AeropuertoTest {
    //Creo las variables que luego serán objetos

    //Ciudades
    private Ciudad ciudadA;

    //Aeropuertos
    private Aeropuerto aeropuertoA;
    private Aeropuerto aeropuertoC;

    private List<Aeropuerto> aeropuertos;

    //Vuelos
    private Vuelo vueloAB;
    private Vuelo vueloAB2;
    private Vuelo vueloBA;

    //Escalas
    private Escala escalaA;
    private Escala escalaB;
    private Escala escalaC;

    //Tiempo
    private LocalDateTime fechaHoraSalidaVuelos =
            LocalDateTime.of(2021, 6, 11, 4, 04, 00);

    @Before
    public void inicializacionDeTodo(){
        //En este punto voy inicializar esas variables como instancias de las clases correspondientes.

        //Ciudades
        this.ciudadA = new Ciudad();

        //Aeropuertos
        this.aeropuertoA = new Aeropuerto();
        this.aeropuertoC = new Aeropuerto();

        //Agrego los aeropuertos a las ciudades
        this.ciudadA.agregarAeropuertos(this.aeropuertoA);
        this.ciudadA.agregarAeropuertos(this.aeropuertoC);

        //Vuelos
        this.vueloAB = new Vuelo();
        this.vueloAB2 = new Vuelo();
        this.vueloBA = new Vuelo();

        //Escalas
        this.escalaA = new Escala(aeropuertoA,45);
        this.escalaB = new Escala(aeropuertoA,45);
        this.escalaC = new Escala(aeropuertoC,45);

        //Seteo lo que voy a usar de vuelo
        this.vueloAB.setFechaYHoraDeSalida(this.fechaHoraSalidaVuelos);
        this.vueloAB.setDuracionVueloAproxEnMins(150);
        this.vueloAB.setOrigen(aeropuertoA);

        this.vueloAB2.setFechaYHoraDeSalida(this.fechaHoraSalidaVuelos);
        this.vueloAB2.setDuracionVueloAproxEnMins(150);
        this.vueloAB2.setOrigen(aeropuertoA);

        this.vueloBA.setFechaYHoraDeSalida(this.fechaHoraSalidaVuelos);
        this.vueloBA.setDuracionVueloAproxEnMins(150);
        this.vueloBA.setDestino(aeropuertoA);

        //Instancio la colección de Aropuertos
        this.aeropuertos = new ArrayList<Aeropuerto>();
        this.aeropuertos.add(aeropuertoA);
        this.aeropuertos.add(aeropuertoC);
    }
        //cantDeVuelosArrivadosComoEscalas, cantDeVuelosQueLlegaronEn, cantDeVuelosQuePartieronEn
    @Test
    public void cantidadDeEscalas(){
        Assert.assertEquals(2, this.aeropuertoA.cantDeVuelosArrivadosComoEscalas().intValue());
    }

    @Test
    public void aeropuertoConMenosEscalas(){
        Aeropuerto aeropuertoConMenosEscalas = Collections.min(aeropuertos, new Comparator<Aeropuerto>(){
            public int compare(Aeropuerto a, Aeropuerto b) {
                return Integer.compare(a.cantDeVuelosArrivadosComoEscalas().intValue(),
                        b.cantDeVuelosArrivadosComoEscalas().intValue());
            }
        });
        Assert.assertSame(this.aeropuertoC, aeropuertoConMenosEscalas);
    }

    @Test
    public void cantidadDeVuelosQueLlegaronEn(){
        LocalDate fechaAComparar = LocalDate.of(2021, 6, 11);
        Assert.assertEquals(1, this.aeropuertoA.cantDeVuelosQueLlegaronEn(fechaAComparar).intValue());
    }

    @Test
    public void cantidadDeVuelosQuePartieronEn(){
        LocalDate fechaAComparar = LocalDate.of(2021, 6, 11);
        Assert.assertEquals(2, this.aeropuertoA.cantDeVuelosQuePartieronEn(fechaAComparar).intValue());
    }

}
