package dominio.PersonalYPasajeros;

import dominio.PersonalYPasajeros.Persona.Persona;
import dominio.PersonalYPasajeros.Persona.TipoDeDocumento;

import java.util.Collection;

public class Personal extends Persona{
    /** Atributos **/
    private Cargo cargo;

    /** Constructor **/
    public Personal(Cargo cargo) {
        this.cargo = cargo;
    }

    /** Setters & Getters **/

    /** Métodos **/
}
