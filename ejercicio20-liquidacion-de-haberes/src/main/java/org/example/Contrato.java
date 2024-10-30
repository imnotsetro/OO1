package org.example;

import java.time.LocalDate;

public abstract class Contrato {
    private LocalDate fechaInicio;
    private Empleado propietario;

    public Contrato(LocalDate fechaInicio, Empleado propietario) {
        this.fechaInicio = fechaInicio;
        this.propietario = propietario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Empleado getPropietario() {
        return propietario;
    }

    public void setPropietario(Empleado propietario) {
        this.propietario = propietario;
    }

    protected double getTotal () {
        //Se tiene que revisar uno por uno los contratos y sumar sus años
    }
}
