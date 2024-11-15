package org.example;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
    private Conductor propietario;
    private String descripcion;
    private int capacidad;
    private Year anioFabricacion;
    private double valorMercado;

    public Vehiculo(Conductor propietario, String descripcion, int capacidad, Year anioFabricacion, double valorMercado) {
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.anioFabricacion = anioFabricacion;
        this.valorMercado = valorMercado;
    }

    public Conductor getPropietario() {
        return propietario;
    }

    public void setPropietario(Conductor propietario) {
        this.propietario = propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Year getAnioFabricacion() {
        return anioFabricacion;
    }

    public boolean esMenosViejo(int anios){
        return ChronoUnit.YEARS.between(this.anioFabricacion, LocalDate.now()) < anios;
    }

    public boolean hayLugar(int cant){
        return this.capacidad > cant;
    }

    public double getValorMercado() {
        return valorMercado;
    }
}
