package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Vacunacion extends ServicioIntervenido{
    private String vacuna;
    private double costo;
    private LocalDate fechaIngreso;

    public Vacunacion(Mascota mascota, LocalDate fechaAtencion, Medico medico, String vacuna, double costo, LocalDate fechaIngreso) {
        super(mascota, fechaAtencion, medico);
        this.vacuna = vacuna;
        this.costo = costo;
        this.fechaIngreso = fechaIngreso;
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

    protected double calcularCosto() {
        if (this.fechaIngreso.getDayOfWeek() == DayOfWeek.of(7)) {
            return this.getCostoMaterialDescartable() + this.costo + this.getAdicionalDomingo() + (this.getMedico().getFechaIngreso().getYear() - LocalDate.now().getYear()) * 100.0;
        }
        return this.getCostoMaterialDescartable() + this.costo + (this.getMedico().getFechaIngreso().getYear() - LocalDate.now().getYear()) * 100.0;
    }
}
