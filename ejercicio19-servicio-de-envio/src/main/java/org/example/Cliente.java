package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    String nombre;
    String direccion;
    List<Envio> envios;

    public Cliente(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
        envios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public void agregarEnvio (Envio unEnvio) {
        this.envios.add(unEnvio);
    }

    public abstract double calcularMonto (LocalDate inicio, LocalDate fin);
}
