package org.example;

import java.time.LocalDate;

public abstract class ServicioIntervenido extends Servicio{
    private Medico medico;

    public ServicioIntervenido(Mascota mascota, LocalDate fechaAtencion, Medico medico) {
        super(mascota, fechaAtencion);
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    protected double calcularCosto() {
        return this.medico.getHonorarios() + this.calcularCosto();
    }
}
