package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private String origen;
    private String destino;
    private double costoTotal;
    private Vehiculo vehiculo;
    private LocalDate fechaViaje;
    private List<Usuario> listaPasajeros;

    public Viaje(String origen, String destino, double costoTotal, Vehiculo vehiculo, LocalDate fechaViaje) {
        this.origen = origen;
        this.destino = destino;
        this.costoTotal = costoTotal;
        this.vehiculo = vehiculo;
        this.fechaViaje = fechaViaje;
        this.listaPasajeros = new ArrayList<>();
        this.agregarPasajero(this.vehiculo.getPropietario());
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
        if (this.vehiculo.hayLugar(this.getCantPasajeros())){
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
