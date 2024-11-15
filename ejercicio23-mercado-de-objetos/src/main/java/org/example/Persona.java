package org.example;

public abstract class Persona {
    private final String nombre;
    private final String direccion;

    public Persona(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
