package org.example;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {
    private double valorHora;
    private int cantHoras;
    private LocalDate fechaFin;

    public ContratoPorHoras(LocalDate fechaInicio, Empleado propietario, double valorHora, int cantHoras, LocalDate fechaFin) {
        super(fechaInicio, propietario);
        this.valorHora = valorHora;
        this.cantHoras = cantHoras;
        this.fechaFin = fechaFin;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotal() {
        return this.cantHoras * this.valorHora;
    }
}
