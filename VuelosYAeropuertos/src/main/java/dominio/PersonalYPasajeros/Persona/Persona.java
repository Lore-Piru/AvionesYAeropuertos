package dominio.PersonalYPasajeros.Persona;

public abstract class Persona {

    /** Atributos **/
    protected String apellido;
    protected String nombre;
    protected TipoDeDocumento tipoDeDocumento;
    protected Integer numDeDocumento;

    /** Constructor **/
    protected Persona() {
    }
    /** Setters & Getters **/
    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    protected void setNumDeDocumento(Integer numDeDocumento) {
        this.numDeDocumento = numDeDocumento;
    }

    /** Métodos **/
}
