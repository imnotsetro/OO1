package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class Servicio {
    private final Mascota mascota;
    private final LocalDate fechaAtencion;

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


    public boolean isDomingo(){
        return this.getFechaAtencion().getDayOfWeek() == DayOfWeek.of(7);
    }

    abstract protected double calcularCosto();
}
