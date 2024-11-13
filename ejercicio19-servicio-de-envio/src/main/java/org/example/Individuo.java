package org.example;

import java.time.LocalDate;

public class Individuo extends Cliente {
    int dni;

    public Individuo(String direccion, String nombre, int dni) {
        super(direccion, nombre);
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    protected double descuento() {
        return 0.90;
    }
}
