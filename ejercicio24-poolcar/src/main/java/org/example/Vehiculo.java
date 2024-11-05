package org.example;

public class Vehiculo {
    private Conductor propietario;
    private String descripcion;
    private int capacidad;
    private int anioFabricacion;
    private double valorMercado;

    public Vehiculo(Conductor propietario, String descripcion, int capacidad, int anioFabricacion, double valorMercado) {
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.anioFabricacion = anioFabricacion;
        this.valorMercado = valorMercado;
    }

    public Conductor getPropietario() {
        return propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public double getValorMercado() {
        return valorMercado;
    }
}
