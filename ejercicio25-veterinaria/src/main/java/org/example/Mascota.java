package org.example;

import java.time.LocalDate;
import java.util.List;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private List<Servicio> servicios;

    public Mascota(String nombre, LocalDate fechaNacimiento, String especie, List<Servicio> servicios) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void darAltaServicio(Servicio servicio){
        this.servicios.add(servicio);
    }

    public boolean isCantMayor(int aux){
        return (this.servicios.size() >= aux);
    }

    public double getRecaudacionGenerada(LocalDate unaFecha){
        return this.servicios.stream().filter(s -> s.getFechaAtencion().equals(unaFecha)).mapToDouble(s -> s.calcularCosto()).sum();
    }
}
