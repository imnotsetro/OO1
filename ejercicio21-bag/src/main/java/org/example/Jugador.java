package org.example;

public class Jugador {
    private final String nombre;
    private final String apellido;

    public Jugador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
