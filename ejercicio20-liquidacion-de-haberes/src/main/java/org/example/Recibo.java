package org.example;

import java.time.LocalDate;

public class Recibo {
    private Empleado propietario;
    private LocalDate fechaGenerado;
    private double montoTotal;

    public Recibo(Empleado propietario) {
        this.propietario = propietario;
        this.fechaGenerado = LocalDate.now();
        this.montoTotal = propietario.getTotalContratos() * propietario.getBonusAntiguedadEmpleado();
    }

    public Empleado getPropietario() {
        return propietario;
    }

    public LocalDate getFechaGenerado() {
        return fechaGenerado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
