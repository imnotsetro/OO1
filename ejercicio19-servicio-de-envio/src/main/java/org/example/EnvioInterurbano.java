package org.example;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio{
    double distancia;

    public EnvioInterurbano(LocalDate fechaDespacho, String direccionOrigen, String direccionEnvio, double peso, double distancia) {
        super(fechaDespacho, direccionOrigen, direccionEnvio, peso);
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double calcularMonto(){
        if (this.distancia < 100) {
            return 20.0 * this.peso;
        } else {
            if (this.distancia < 500) {
                return 25 * this.peso;
            } else {
                return 30 * this.peso;
            }
        }
    }
}
