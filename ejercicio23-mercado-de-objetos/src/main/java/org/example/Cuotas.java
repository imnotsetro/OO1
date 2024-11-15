package org.example;

public class Cuotas implements MetodoPago{

    public Cuotas() {
    }

    @Override
    public double calcularCosto(double monto) {
        return monto * 0.20;
    }
}
