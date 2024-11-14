package org.example;

import java.util.List;

public abstract class Usuario {
    private String nombre;
    private double saldo;
    private List<Viaje> viajesRealizados;

    public Usuario(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    abstract public double getComision();

    abstract public void pagarViaje(double monto);

    protected void procesarViaje(Viaje viaje, double monto){
        this.viajesRealizados.add(viaje);
        this.pagarViaje(monto);
    }

    protected void cargarSaldo(double monto){
        this.saldo += (monto - (monto * this.getComision()));
    }

    protected void descontarSaldo(double monto){
        this.saldo -= monto;
    }
}
