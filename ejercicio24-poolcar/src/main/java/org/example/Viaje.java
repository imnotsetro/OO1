package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private final String origen;
    private final String destino;
    private final double costoTotal;
    private final Vehiculo vehiculo;
    private final LocalDate fechaViaje;
    private final List<Usuario> listaPasajeros;

    public Viaje(String origen, String destino, double costoTotal, Vehiculo vehiculo, LocalDate fechaViaje) {
        this.origen = origen;
        this.destino = destino;
        this.costoTotal = costoTotal;
        this.vehiculo = vehiculo;
        this.fechaViaje = fechaViaje;
        this.listaPasajeros = new ArrayList<>();
        this.listaPasajeros.add(this.vehiculo.getPropietario());
    }

    public String getOrigen() {
        return origen;
    }

    public int getCantPasajeros(){
        return this.listaPasajeros.size();
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

    public void agregarPasajero(Usuario usuario) {
        if (this.vehiculo.hayLugar(this.getCantPasajeros()) && (this.fechaViaje.isBefore(LocalDate.now().minusDays(2)))){
            this.listaPasajeros.add(usuario);
        }
    }

    public boolean fechaAnteriorADias(int dias){
        return this.fechaViaje.isBefore(LocalDate.now().minusDays(dias));
    }

    public double getCostoIndividual() {
        return this.costoTotal / this.getCantPasajeros();
    }

    public void procesarViaje() {
        this.listaPasajeros.forEach(u -> u.procesarViaje(this, this.getCostoIndividual()));
    }
}
