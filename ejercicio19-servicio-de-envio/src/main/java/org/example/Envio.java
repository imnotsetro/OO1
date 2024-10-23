package org.example;

import java.time.LocalDate;

public abstract class Envio {
    LocalDate fechaDespacho;
    String direccionOrigen;
    String direccionEnvio;
    double peso;

    public Envio(LocalDate fechaDespacho, String direccionOrigen, String direccionEnvio, double peso) {
        this.fechaDespacho = fechaDespacho;
        this.direccionOrigen = direccionOrigen;
        this.direccionEnvio = direccionEnvio;
        this.peso = peso;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFecaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public abstract double calcularMonto();
}
