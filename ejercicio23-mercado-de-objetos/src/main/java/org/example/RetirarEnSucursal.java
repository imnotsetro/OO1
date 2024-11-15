package org.example;

public class RetirarEnSucursal implements Envio{

    public RetirarEnSucursal() {
    }

    private double getCosto() {
        return 3000.0;
    }

    @Override
    public double calcularCosto() {
        return this.getCosto();
    }
}
