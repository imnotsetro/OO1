package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato{
    double sueldoMensual;
    double montoConyuge;
    double montoHijo;

    public ContratoDePlanta(LocalDate fechaInicio, Empleado propietario, double montoHijo, double montoConyuge, double sueldoMensual) {
        super(fechaInicio, propietario);
        this.montoHijo = montoHijo;
        this.montoConyuge = montoConyuge;
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public double getMontoConyuge() {
        return montoConyuge;
    }

    public void setMontoConyuge(double montoConyuge) {
        this.montoConyuge = montoConyuge;
    }

    public double getMontoHijo() {
        return montoHijo;
    }

    public void setMontoHijo(double montoHijo) {
        this.montoHijo = montoHijo;
    }

    public int getAntiguedadContrato(){
        return (int) ChronoUnit.DAYS.between(this.getFechaInicio(), LocalDate.now());
    }

    public double getTotal() {
        double total = this.getSueldoMensual();
        if (this.getPropietario().isTieneHijo()) {
            total += this.getMontoHijo();
        }
        if (this.getPropietario().isTieneConyuge()) {
            total += this.getMontoConyuge();
        }
        return total;
    }
}
