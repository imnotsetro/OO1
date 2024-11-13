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
        return this.getCostoMaterialDescartable() + this.getAdicional();
    }

    protected double calcularCostoTotal() {
        if (this.isDomingo()) {
            return this.getCostoTotal() + this.getAdicionalDomingo();
        } else {
            return this.getCostoTotal();
        }
    }
}
