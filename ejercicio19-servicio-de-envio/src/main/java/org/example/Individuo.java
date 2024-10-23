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
    public double calcularMonto(LocalDate inicio, LocalDate fin) {
        DataLapse dl = new DataLapse(inicio, fin);
        return (this.envios.stream().filter(e -> dl.includesDate(e.getFechaDespacho())).mapToDouble(e -> e.calcularMonto()).sum() * 0.90);
    }
}
