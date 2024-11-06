package org.example;

import java.time.LocalDate;

public abstract class Servicio {
    private Mascota mascota;
    private LocalDate fechaAtencion;

    public Servicio(Mascota mascota, LocalDate fechaAtencion) {
        this.mascota = mascota;
        this.fechaAtencion = fechaAtencion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    abstract protected double calcularCosto();
}
