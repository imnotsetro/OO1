package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Vacunacion extends ServicioIntervenido{
    private String vacuna;
    private double costo;

    public Vacunacion(Mascota mascota, LocalDate fechaAtencion, Medico medico, String vacuna, double costo, LocalDate fechaIngreso) {
        super(mascota, fechaAtencion, medico);
        this.vacuna = vacuna;
        this.costo = costo;
    }

    public String getVacuna() {
        return vacuna;
    }

    public double getCosto() {
        return costo;
    }

    private double getCostoMaterialDescartable(){
        return 500.0;
    }

    private double getAdicionalDomingo(){
        return 200.0;
    }

    private double getCostoTotal(){
        return this.getCostoMaterialDescartable() + this.costo + (this.getMedico().getFechaIngreso().getYear() - LocalDate.now().getYear()) * 100.0;
    }

    protected double calcularCosto() {
        if (this.isDomingo()) {
            return this.getCostoTotal() + this.getAdicionalDomingo();
        }
        return this.getCostoTotal();

    }
}
