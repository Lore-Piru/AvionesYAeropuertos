package dominio.AeropuertoYEtc;

public class Avion {

    /** Atributos **/
    private Aerolinea aerolinea;
    private Integer cantAsientosTotales;

    /** Constructor **/
    public Avion(Integer cantAsientosTotales, Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
        this.cantAsientosTotales = cantAsientosTotales;
    }

    /** Setters & Getters **/
    public Integer getCantAsientosTotales() {
        return cantAsientosTotales;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    /** Métodos **/
}
