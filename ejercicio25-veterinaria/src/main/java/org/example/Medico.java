package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medico {
    private final String nombre;
    private final LocalDate fechaIngreso;
    private final double honorarios;

    public Medico(String nombre, LocalDate fechaIngreso, double honorarios) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.honorarios = honorarios;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public double getAniosServicio(){
        return ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
    }
}
