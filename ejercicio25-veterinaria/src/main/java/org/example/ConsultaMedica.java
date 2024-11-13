package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ConsultaMedica extends ServicioIntervenido{

    public ConsultaMedica(Mascota mascota, Medico medico, LocalDate fechaAtencion) {
        super(mascota, fechaAtencion, medico);
    }

    private double getCostoMaterialDescartable(){
        return 300.0;
    }

    private double getAdicionalDomingo(){
        return 200.0;
    }

    private double getCostoTotal() {

    }

    protected double calcularCosto() {
        if (this.isDomingo()) {
            return this.getCostoMaterialDescartable() + this.getAdicionalDomingo() + (this.getMedico().getFechaIngreso().getYear() - LocalDate.now().getYear()) * 100.0;
        } else {
            return this.getCostoMaterialDescartable() + (this.getMedico().getFechaIngreso().getYear() - LocalDate.now().getYear()) * 100.0;
        }
    }
}
