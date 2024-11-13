package org.example;

import java.time.LocalDate;
import java.util.List;

public class Viaje {
    private String origen;
    private String destino;
    private double costoTotal;
    private Vehiculo vehiculo;
    private LocalDate fechaViaje;
    private int espacioDisponible;
    private List<Usuario> listaPasajes;

    public Viaje(String origen, String destino, double costoTotal, Vehiculo vehiculo, LocalDate fechaViaje) {
        this.origen = origen;
        this.destino = destino;
        this.costoTotal = costoTotal;
        this.vehiculo = vehiculo;
        this.fechaViaje = fechaViaje;
        this.espacioDisponible = vehiculo.getCapacidad() - 1;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public int getEspacioDisponible() {
        return espacioDisponible;
    }

    public void agregarPasajero() {
        this.espacioDisponible --;
    }

    //Rarisimo: En caso de que no se deba hacer asi la segunda opcion seria crear una lista de viajes para el conductor tambien.. lo que no pide el enunciado
    public void procesarViajeConductor(){
        this.vehiculo.getPropietario().procesarViaje(this, this.getCostoTotalIndividual());
    }

    public double getCostoTotalIndividual() {
        return this.getCostoTotal() / (this.getVehiculo().getCapacidad() - (this.getEspacioDisponible()));
    }
}
